package com.example.springbatchgreater5.chunkProcessing.config;

import com.example.springbatchgreater5.chunkProcessing.domain.ProductRowMapper;
import com.example.springbatchgreater5.chunkProcessing.entity.OSProduct;
import com.example.springbatchgreater5.chunkProcessing.entity.Product;
import com.example.springbatchgreater5.chunkProcessing.processor.FilterProductItemProcessor;
import com.example.springbatchgreater5.chunkProcessing.processor.TransformProductItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.batch.item.validator.BeanValidatingItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class BatchConfiguration1 {


    @Autowired
    private DataSource dataSource;

    //Transform ItemProcessor - Chaining
    @Bean
    public ItemReader<Product> jdbcPagingItemReader() throws Exception {
        JdbcPagingItemReader<Product> itemReader = new JdbcPagingItemReader<>();
        itemReader.setDataSource(dataSource);

        SqlPagingQueryProviderFactoryBean factoryBean = new SqlPagingQueryProviderFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setSelectClause("select product_id,product_name,product_category,product_price");
        factoryBean.setFromClause("from product_details");
        factoryBean.setSortKey("product_id");

        itemReader.setQueryProvider(factoryBean.getObject());
        itemReader.setRowMapper(new ProductRowMapper());
        itemReader.setPageSize(3);

        System.out.println("itemReader :"+itemReader);
        return itemReader;
    }

    @Bean
    public JdbcBatchItemWriter<OSProduct> jdbcBatchItemWriter() {
        JdbcBatchItemWriter<OSProduct> batchItemWriter = new JdbcBatchItemWriter<>();
        batchItemWriter.setDataSource(dataSource);
        batchItemWriter.setSql("insert into os_product_details values (:productId,:productName,:productCategory,:productPrice,:taxPercent,:sku,:shippingRate)");
        //batchItemWriter.setSql("insert into os_product_details values (?,?,?,?,?,?,?)");
        batchItemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        System.out.println("batchItemWriter :"+batchItemWriter);
        return batchItemWriter;
    }

    @Bean
    public BeanValidatingItemProcessor<Product> beanValidatingItemProcessor() {
        BeanValidatingItemProcessor<Product> beanValidatingItemProcessor = new BeanValidatingItemProcessor<>();
        beanValidatingItemProcessor.setFilter(true);
        return beanValidatingItemProcessor;
    }

    @Bean
    public ItemProcessor<Product,Product> filterProductItemProcessor() {
        return new FilterProductItemProcessor();
    }

    @Bean
    public ItemProcessor<Product, OSProduct> transformProductItemProcessor() {
        return new TransformProductItemProcessor();
    }

    @Bean
    public CompositeItemProcessor<Product, OSProduct> compositeItemProcessor(){
        CompositeItemProcessor<Product,OSProduct> compositeItemProcessor = new CompositeItemProcessor<>();
        List itemProcessor = new ArrayList<>();
        itemProcessor.add(beanValidatingItemProcessor());
        itemProcessor.add(filterProductItemProcessor());
        itemProcessor.add(transformProductItemProcessor());
        compositeItemProcessor.setDelegates(itemProcessor);
        return compositeItemProcessor;
    }

    @Bean
    public Step chunkBasedStep1(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) throws Exception {
        return new StepBuilder("chunkBasedStep1",jobRepository)
                .<Product, OSProduct>chunk(3,platformTransactionManager)
                .reader(jdbcPagingItemReader())
                .processor(compositeItemProcessor())
                .writer(jdbcBatchItemWriter()).build();
    }


    @Bean
    public Job firstJob(JobRepository jobRepository,PlatformTransactionManager platformTransactionManager) throws Exception {
        return new JobBuilder("job1",jobRepository)
                .start(chunkBasedStep1(jobRepository,platformTransactionManager))
                .build();
    }

}
