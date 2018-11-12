package java2.Processor;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.ArrayList;
import java.util.Arrays;

public class ProcessorInput {

    private ArrayList<String> inputFiles;

    // Processing Controls
    private boolean AllSubjects;
    private boolean GroupAveragePerCategories;
    private boolean ComputeReactionTimeOnly;
    private boolean SaveReactionTimesToFile;

    // Epoch Extraction
    private Integer EpochLock;
    public static final Integer EPOCH_LOCK_STIMULUS_LOCKED = 0;
    public static final Integer EPOCH_LOCK_RESPONSE_LOCKED = 1;

    private Integer EpochPreTrigger;
    private Integer EpochPostTrigger;
    private boolean EpochAverageReferencing;

    // Epoch Processing
    private Integer EpochProcessing;
    public static final Integer EPOCH_PROCESSING_AVERAGE_EPOCHS = 0;
    public static final Integer EPOCH_PROCESSING_SORT_EPOCHS = 1;

    private boolean EpochShowRawData;
    private boolean EpochSignificantActivityDetection;
    private boolean EpochLaplace;

    public ArrayList<String> getInputFiles() {
        return inputFiles;
    }

    public void setInputFiles(ArrayList<String> inputFiles) {
        this.inputFiles = inputFiles;
    }

    public boolean isAllSubjects() {
        return AllSubjects;
    }

    public void setAllSubjects(boolean allSubjects) {
        AllSubjects = allSubjects;
    }

    public boolean isGroupAveragePerCategories() {
        return GroupAveragePerCategories;
    }

    public void setGroupAveragePerCategories(boolean groupAveragePerCategories) {
        GroupAveragePerCategories = groupAveragePerCategories;
    }

    public boolean isComputeReactionTimeOnly() {
        return ComputeReactionTimeOnly;
    }

    public void setComputeReactionTimeOnly(boolean computeReactionTimeOnly) {
        ComputeReactionTimeOnly = computeReactionTimeOnly;
    }

    public boolean isSaveReactionTimesToFile() {
        return SaveReactionTimesToFile;
    }

    public void setSaveReactionTimesToFile(boolean saveReactionTimesToFile) {
        SaveReactionTimesToFile = saveReactionTimesToFile;
    }

    public Integer getEpochLock() {
        return EpochLock;
    }

    public void setEpochLock(Integer epochLock) throws InvalidArgumentException {
        if (epochLock < 0 || 1 < epochLock) {
            throw new InvalidArgumentException(new String[]{"epochLock argument must be between 0 and 1!"});
        }

        EpochLock = epochLock;
    }

    public Integer getEpochPreTrigger() {
        return EpochPreTrigger;
    }

    public void setEpochPreTrigger(Integer epochPreTrigger) {
        EpochPreTrigger = epochPreTrigger;
    }

    public Integer getEpochPostTrigger() {
        return EpochPostTrigger;
    }

    public void setEpochPostTrigger(Integer epochPostTrigger) {
        EpochPostTrigger = epochPostTrigger;
    }

    public boolean isEpochAverageReferencing() {
        return EpochAverageReferencing;
    }

    public void setEpochAverageReferencing(boolean epochAverageReferencing) {
        EpochAverageReferencing = epochAverageReferencing;
    }

    public Integer getEpochProcessing() {
        return EpochProcessing;
    }

    public void setEpochProcessing(Integer epochProcessing) throws InvalidArgumentException {
        if (epochProcessing < 0 || 1 < epochProcessing) {
            throw new InvalidArgumentException(new String[]{"epochProcessing argument must be between 0 and 1!"});
        }

        EpochProcessing = epochProcessing;
    }

    public boolean isEpochShowRawData() {
        return EpochShowRawData;
    }

    public void setEpochShowRawData(boolean epochShowRawData) {
        EpochShowRawData = epochShowRawData;
    }

    public boolean isEpochSignificantActivityDetection() {
        return EpochSignificantActivityDetection;
    }

    public void setEpochSignificantActivityDetection(boolean epochSignificantActivityDetection) {
        EpochSignificantActivityDetection = epochSignificantActivityDetection;
    }

    public boolean isEpochLaplace() {
        return EpochLaplace;
    }

    public void setEpochLaplace(boolean epochLaplace) {
        EpochLaplace = epochLaplace;
    }

    public boolean fullyInitialized() {

        try {
            Arrays.stream(getClass().getFields()).forEach(field -> {
                field.setAccessible(true);

                try {
                    if (field.get(this) == null) {
                        throw new RuntimeException("At least one of the fields is not initialized!");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        } catch (RuntimeException e) {
            return false;
        }

        return true;
    }
}
