package example.springbatch.demospringbatch.listeners;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class DemoStepExecutionListener implements StepExecutionListener {

    @Override
    public void beforeStep(StepExecution stepExecution) {

        System.out.println("Before Step: Step Name: " + stepExecution.getStepName());
        System.out.println("Before Step: Step Execution Name: " + stepExecution.getExecutionContext().toString());

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {

        System.out.println("After Step: Step Name: " + stepExecution.getStepName());
        System.out.println("After Step: Step Execution Name: " + stepExecution.getExecutionContext().toString());
        return null;
    }
}
