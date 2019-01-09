package com.psocratic.workchop.examples.embeddedjetty;

import com.psocratic.workchop.step.Step;
import com.psocratic.workchop.step.StepExecutionException;
import com.psocratic.workchop.util.kit.Kit2;

import java.util.List;

final class ConfigurationSteps {
    private ConfigurationSteps() {}

    static class CreateConfiguration implements Step<Kit2<String, Integer>, Configuration> {
        @Override
        public Configuration execute(Kit2<String, Integer> input) throws StepExecutionException {
            return new BasicConfiguration(input.one(), input.two());
        }
    }

    static class ExtractPath implements Step<List<String>, String> {
        @Override
        public String execute(List<String> input) throws StepExecutionException {
            String path = null;

            for(int i = 0; i < input.size(); i++) {
                String flag = input.get(i);
                if(flag.equals("--path")) {
                    int nextIndex = i + 1;
                    if(nextIndex >= input.size())
                        throw new StepExecutionException("An argument is required for the --path flag");
                    path = input.get(nextIndex);
                }
            }

            if(path == null)
                throw new StepExecutionException("No --path flag was provided");

            return path;
        }
    }

    static class ExtractPort implements Step<List<String>, Integer> {
        @Override
        public Integer execute(List<String> input) throws StepExecutionException {
            String port = null;

            for(int i = 0; i < input.size(); i++) {
                String flag = input.get(i);
                if(flag.equals("--port")) {
                    int nextIndex = i + 1;
                    if(nextIndex >= input.size())
                        throw new StepExecutionException("An argument is required for the --port flag");
                    port = input.get(nextIndex);
                }
            }

            if(port == null)
                throw new StepExecutionException("No --port flag was provided");

            try {
                return Integer.parseInt(port);
            } catch(NumberFormatException e) {
                throw new StepExecutionException(port + " must be a number");
            }
        }
    }

    static Step<Kit2<String, Integer>, Configuration> createConfiguration() {
        return new CreateConfiguration();
    }

    static Step<List<String>, String> extractPath() {
        return new ExtractPath();
    }

    static Step<List<String>, Integer> extractPort() {
        return new ExtractPort();
    }

}
