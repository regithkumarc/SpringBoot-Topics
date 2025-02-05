package com.example.springbatchless5.chunkProcessing.config;

import com.example.springbatchless5.chunkProcessing.entity.OSProduct;
import com.example.springbatchless5.chunkProcessing.entity.Product;
import com.example.springbatchless5.chunkProcessing.domain.ProductRowMapper;
import com.example.springbatchless5.chunkProcessing.processor.FilterProductItemProcessor;
import com.example.springbatchless5.chunkProcessing.processor.TransformProductItemProcessor;
import com.example.springbatchless5.chunkProcessing.validator.ProductValidator;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.batch.item.validator.BeanValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration1 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DataSource dataSource;

    //String Data
/*    public ItemReader<String> itemReader() {
        List<String> productlist = new ArrayList<>();
        productlist.add("Product 1");
        productlist.add("Product 2");
        productlist.add("Product 3");
        productlist.add("Product 4");
        productlist.add("Product 5");
        productlist.add("Product 6");
        productlist.add("Product 7");
        productlist.add("Product 8");
        return new ProductNameItemReader(productlist);
    }

    @Bean
    public Step chunkBasedStep1() {
        return stepBuilderFactory.get("chunkBasedStep1")
                .<String, String>chunk(3)
                .reader(itemReader())
                .writer(new ItemWriter<String>() {
                    @Override
                    public void write(List<? extends String> list) throws Exception {
                        System.out.println("Chunk Processing Started");
                        list.forEach(System.out::println);
                        System.out.println("Chunk Processing Ended");
                    }
                }).build();
    }

    @Bean
    public Job firstJob() throws Exception {
        return jobBuilderFactory.get("job1")
                //.preventRestart()
                .start(chunkBasedStep1())
                .build();
    }*/



    //Reading Data from CSV
/*    @Bean
    public ItemReader<Product> flatFileItemReader() {
        FlatFileItemReader<Product> reader = new FlatFileItemReader<>();
        reader.setLinesToSkip(1);
        reader.setResource(new ClassPathResource("/data/Product_Details.csv"));

        DefaultLineMapper<Product> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames("product_id", "product_name", "product_category", "product_price");

        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(new ProductFieldsetMapper());

        reader.setLineMapper(lineMapper);
        return reader;
    }

    @Bean
    public Step chunkBasedStep2() {
        return stepBuilderFactory.get("chunkBasedStep2")
                .<Product, Product>chunk(3)
                .reader(flatFileItemReader())
                .writer(new ItemWriter<Product>() {
                    @Override
                    public void write(List<? extends Product> list) throws Exception {
                        System.out.println("Chunk Processing Started");
                        list.forEach(System.out::println);
                        System.out.println("Chunk Processing Ended");
                    }
                }).build();
    }

    @Bean
    public Job secondJob() throws Exception {
        return jobBuilderFactory.get("job1")
                //.preventRestart()
                .start(chunkBasedStep2())
                .build();
    }*/


    //Reading Data from Database
/*    @Bean
    public ItemReader<Product> jdbcItemReader() {
        JdbcCursorItemReader<Product> itemReader = new JdbcCursorItemReader<>();
        itemReader.setDataSource(dataSource);
        itemReader.setSql("select * from product_details order by product_id");
        itemReader.setRowMapper(new ProductRowMapper());
        return itemReader;
    }

    @Bean
    public Step chunkBasedStep3() {
        return stepBuilderFactory.get("chunkBasedStep3")
                .<Product, Product>chunk(3)
                .reader(jdbcItemReader())
                .writer(new ItemWriter<Product>() {
                    @Override
                    public void write(List<? extends Product> list) throws Exception {
                        System.out.println("Chunk Processing Started");
                        list.forEach(System.out::println);
                        System.out.println("Chunk Processing Ended");
                    }
                }).build();
    }

    @Bean
    public Job thirdJob() throws Exception {
        return jobBuilderFactory.get("job1")
                //.preventRestart()
                .start(chunkBasedStep3())
                .build();
    }*/


    //Reading Paging Data from Database ... It will support for all database
/*    @Bean
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

        return itemReader;
    }

    @Bean
    public ItemWriter<Product> flatFileItemWriter() {
        FlatFileItemWriter<Product> itemWriter = new FlatFileItemWriter<>();
        itemWriter.setResource(new FileSystemResource("src/main/resources/data/Product_Details_output.csv"));

        DelimitedLineAggregator<Product> lineAggregator = new DelimitedLineAggregator<>();
        lineAggregator.setDelimiter(",");

        BeanWrapperFieldExtractor<Product> fieldExtractor = new BeanWrapperFieldExtractor();
        fieldExtractor.setNames(new String[]{"productId","productName","productCategory","productPrice"});

        lineAggregator.setFieldExtractor(fieldExtractor);

        itemWriter.setLineAggregator(lineAggregator);
        return itemWriter;
    }


    @Bean
    public Step chunkBasedStep4() throws Exception {
        return stepBuilderFactory.get("chunkBasedStep4")
                .<Product, Product>chunk(3)
                .reader(jdbcPagingItemReader())
                .writer(flatFileItemWriter()).build();
    }

    @Bean
    public Job fourthJob() throws Exception {
        return jobBuilderFactory.get("job1")
                //.preventRestart()
                .start(chunkBasedStep4())
                .build();
    }*/


    //Writing Data to Database
/*    @Bean
    public JdbcBatchItemWriter<Product> jdbcBatchItemWriter() {
        JdbcBatchItemWriter<Product> batchItemWriter = new JdbcBatchItemWriter<>();
        batchItemWriter.setDataSource(dataSource);
        batchItemWriter.setSql("insert into product_details_output values (?,?,?,?)");
        batchItemWriter.setItemPreparedStatementSetter(new ProductItemPrepareStatementSetter());
        return batchItemWriter;
    }

    @Bean
    public JdbcBatchItemWriter<Product> jdbcBatchItemWriter() {
        JdbcBatchItemWriter<Product> batchItemWriter = new JdbcBatchItemWriter<>();
        batchItemWriter.setDataSource(dataSource);
        batchItemWriter.setSql("insert into product_details_output values (:productId,:productName,:productCategory,:productPrice)");
        batchItemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        return batchItemWriter;
    }

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

        return itemReader;
    }

    @Bean
    public Step chunkBasedStep5() throws Exception {
        return stepBuilderFactory.get("chunkBasedStep5")
                .<Product, Product>chunk(3)
                .reader(jdbcPagingItemReader())
                .writer(jdbcBatchItemWriter()).build();
    }

    @Bean
    public Job fifthJob() throws Exception {
        return jobBuilderFactory.get("job1")
                //.preventRestart()
                .start(chunkBasedStep5())
                .build();
    }*/


    // Transformation input type and output type same / Different
/*    @Bean
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

        return itemReader;
    }

    @Bean
    public JdbcBatchItemWriter<Product> jdbcBatchItemWriter() {
        JdbcBatchItemWriter<Product> batchItemWriter = new JdbcBatchItemWriter<>();
        batchItemWriter.setDataSource(dataSource);
        batchItemWriter.setSql("insert into product_details_output values (:productId,:productName,:productCategory,:productPrice)");
        batchItemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        return batchItemWriter;
    }

    @Bean
    public ItemProcessor<Product,Product> itemProcessor() {
        return new MyProductItemProcessor();
    }

    @Bean
    public Step chunkBasedStep6() throws Exception {
        return stepBuilderFactory.get("chunkBasedStep6")
                .<Product, Product>chunk(3)
                .reader(jdbcPagingItemReader())
                .processor(itemProcessor())
                .writer(jdbcBatchItemWriter()).build();
    }


    @Bean
    public Job sixthJob() throws Exception {
        return jobBuilderFactory.get("job1")
                //.preventRestart()
                .start(chunkBasedStep6())
                .build();
    }*/


    // Filtered data
/*    @Bean
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

        return itemReader;
    }

    @Bean
    public JdbcBatchItemWriter<Product> jdbcBatchItemWriter() {
        JdbcBatchItemWriter<Product> batchItemWriter = new JdbcBatchItemWriter<>();
        batchItemWriter.setDataSource(dataSource);
        batchItemWriter.setSql("insert into product_details_output values (:productId,:productName,:productCategory,:productPrice)");
        batchItemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        return batchItemWriter;
    }

    @Bean
    public ItemProcessor<Product,Product> itemProcessor() {
        return new FilterProductItemProcessor();
    }

    @Bean
    public Step chunkBasedStep7() throws Exception {
        return stepBuilderFactory.get("chunkBasedStep7")
                .<Product, Product>chunk(3)
                .reader(jdbcPagingItemReader())
                .processor(itemProcessor())
                .writer(jdbcBatchItemWriter()).build();
    }


    @Bean
    public Job sevenJob() throws Exception {
        return jobBuilderFactory.get("job1")
                //.preventRestart()
                .start(chunkBasedStep7())
                .build();
    }*/


    // Validation data
/*    @Bean
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

        return itemReader;
    }

    @Bean
    public JdbcBatchItemWriter<Product> jdbcBatchItemWriter() {
        JdbcBatchItemWriter<Product> batchItemWriter = new JdbcBatchItemWriter<>();
        batchItemWriter.setDataSource(dataSource);
        batchItemWriter.setSql("insert into product_details_output values (:productId,:productName,:productCategory,:productPrice)");
        batchItemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        return batchItemWriter;
    }

    @Bean
    public ValidatingItemProcessor<Product> itemProcessor() {
        ValidatingItemProcessor<Product> validatingItemProcessor = new ValidatingItemProcessor<>(new ProductValidator());
        validatingItemProcessor.setFilter(true);
        return validatingItemProcessor;
    }

    @Bean
    public Step chunkBasedStep8() throws Exception {
        return stepBuilderFactory.get("chunkBasedStep8")
                .<Product, Product>chunk(3)
                .reader(jdbcPagingItemReader())
                .processor(itemProcessor())
                .writer(jdbcBatchItemWriter()).build();
    }


    @Bean
    public Job eightJob() throws Exception {
        return jobBuilderFactory.get("job1")
                //.preventRestart()
                .start(chunkBasedStep8())
                .build();
    }*/


    // Bean validating item processor
/*    @Bean
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

        return itemReader;
    }

    @Bean
    public JdbcBatchItemWriter<Product> jdbcBatchItemWriter() {
        JdbcBatchItemWriter<Product> batchItemWriter = new JdbcBatchItemWriter<>();
        batchItemWriter.setDataSource(dataSource);
        batchItemWriter.setSql("insert into product_details_output values (:productId,:productName,:productCategory,:productPrice)");
        batchItemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        return batchItemWriter;
    }

    @Bean
    public BeanValidatingItemProcessor<Product> itemProcessor() {
        BeanValidatingItemProcessor<Product> beanValidatingItemProcessor = new BeanValidatingItemProcessor<>();
        beanValidatingItemProcessor.setFilter(true);
        return beanValidatingItemProcessor;
    }

    @Bean
    public Step chunkBasedStep9() throws Exception {
        return stepBuilderFactory.get("chunkBasedStep9")
                .<Product, Product>chunk(3)
                .reader(jdbcPagingItemReader())
                .processor(itemProcessor())
                .writer(jdbcBatchItemWriter()).build();
    }


    @Bean
    public Job nineJob() throws Exception {
        return jobBuilderFactory.get("job1")
                //.preventRestart()
                .start(chunkBasedStep9())
                .build();
    }*/


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

        return itemReader;
    }

    @Bean
    public JdbcBatchItemWriter<OSProduct> jdbcBatchItemWriter() {
        JdbcBatchItemWriter<OSProduct> batchItemWriter = new JdbcBatchItemWriter<>();
        batchItemWriter.setDataSource(dataSource);
        batchItemWriter.setSql("insert into os_product_details values (:productId,:productName,:productCategory,:productPrice,:taxPercent,:sku,:shippingRate)");
        batchItemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
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
    public Step chunkBasedStep10() throws Exception {
        return stepBuilderFactory.get("chunkBasedStep10")
                .<Product, OSProduct>chunk(3)
                .reader(jdbcPagingItemReader())
                .processor(compositeItemProcessor())
                .writer(jdbcBatchItemWriter()).build();
    }


    @Bean
    public Job tenJob() throws Exception {
        return jobBuilderFactory.get("job1")
                //.preventRestart()
                .start(chunkBasedStep10())
                .build();
    }

}
