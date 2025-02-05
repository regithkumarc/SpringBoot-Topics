package com.example.springbatchless5.basic.config;

import com.example.springbatchless5.basic.decider.MyJobExecutionDecider;
import com.example.springbatchless5.basic.listener.MyStepExecutionListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public StepExecutionListener stepExecutionListener(){
        return new MyStepExecutionListener();
    }

    @Bean
    public JobExecutionDecider jobExecutionDecider(){
        return new MyJobExecutionDecider();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("Step1 Executed");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }
/*
    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                boolean status = false;
                if(status) {
                    throw new Exception();
                }
                System.out.println("Step2 Executed");
                return RepeatStatus.FINISHED;
            }
        }).listener(stepExecutionListener()).build();
    }*/

/*    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                boolean status = false;
                if(status) {
                    throw new Exception();
                }
                System.out.println("Step2 Executed");
                return RepeatStatus.FINISHED;
            }
        }).listener(stepExecutionListener()).build();
    }*/

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                boolean status = false;
                if(status) {
                    throw new Exception();
                }
                System.out.println("Step2 Executed");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    @Bean
    public Step step3() {
        return stepBuilderFactory.get("step3").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("Step3 Executed");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    @Bean
    public Step step4() {
        return stepBuilderFactory.get("step4").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("Step4 Executed");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    /*    @Bean
    public Job firstJob() {
        return jobBuilderFactory.get("job1")
                .preventRestart()
                .start(step1())
                .next(step2())
                .next(step3())
                .end()
                .build();
    }*/

/*    @Bean
    public Job firstJob() {
        return jobBuilderFactory.get("job1")
                .preventRestart()
                .start(step1())
                    .on("COMPLETED").to(step2())
                .from(step2())
                    .on("TEST_STATUS").to(step3())
                .from(step2())
                    .on("FAILED").to(step4())
                .end()
                .build();
    }*/

/*    @Bean
    public Job firstJob() {
        return jobBuilderFactory.get("job1")
                .preventRestart()
                .start(step1())
                .on("COMPLETED").to(step2())
                .from(step2())
                .on("COMPLETED").to(step3())
                .from(step2())
                .on("*").to(step4())
                .end()
                .build();
    }*/

    @Bean
    public Job firstJob() {
        return jobBuilderFactory.get("job1")
                .preventRestart()
                .start(step1())
                .on("COMPLETED").to(jobExecutionDecider())
                    .on("TEST_STATUS").to(step2())
                .from(jobExecutionDecider())
                    .on("*").to(step3())
                .end()
                .build();
    }
}
