package java2.Processor;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class TestProcessor implements Processor {

    @Override
    public boolean process(ProcessorInput input, Function progressbarAdvance) {

        input.getInputFiles().forEach(file -> {


            simulateProcessingTime();

        });


        return true;
    }

    private void simulateProcessingTime() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
