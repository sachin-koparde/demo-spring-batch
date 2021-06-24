package example.springbatch.demospringbatch.listeners;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class DemoJobExecutionListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {

        System.out.println("Before Job: Job Name: " + jobExecution.getJobInstance().getJobName());
        System.out.println("Before Job: Job Execution Context: " + jobExecution.getExecutionContext());
        System.out.println("Job execution start time: " + jobExecution.getStartTime());

        jobExecution.getExecutionContext().put("name", "Hello");

    }

    @Override
    public void afterJob(JobExecution jobExecution) {

        System.out.println("After Job: Job Name: " + jobExecution.getJobInstance().getJobName());
        System.out.println("After Job: Job Execution Context: " + jobExecution.getExecutionContext().toString());


    }
}
