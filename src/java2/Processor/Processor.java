package java2.Processor;

import java.util.function.Function;

public interface Processor {

    public boolean process(ProcessorInput processorInput, Function progressbarAdvance);

}