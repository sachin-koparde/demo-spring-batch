package example.springbatch.demospringbatch.config;

import example.springbatch.demospringbatch.listeners.DemoJobExecutionListener;
import example.springbatch.demospringbatch.listeners.DemoStepExecutionListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class AppConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DemoJobExecutionListener demoJobExecutionListener;

    @Autowired
    private DemoStepExecutionListener stepExecutionListener;

    /* A Job is an entity that encapsulates an entire batch process. */
    @Bean
    public Job myJob() {
        return jobBuilderFactory
                .get("myJob")
                .listener(demoJobExecutionListener)
                .start(step1())
                .build();
    }

    /* A Step is a domain object that encapsulates an independent, sequential phase of a batch job. */
    @Bean
    public Step step1() {
        return stepBuilderFactory
                .get("simpleJob")
                .listener(stepExecutionListener)
                .tasklet(tasklet())
                .build();
    }

    private Tasklet tasklet() {
        return (new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("Spring Batch tasklet is processed");
                return RepeatStatus.FINISHED;
            }
        });

    }


}
