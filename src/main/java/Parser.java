import Instruction.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Parser {
    private ArrayList<Instruction> instructions;

    public String[] getParsedLines() {
        return instructions.stream().map(Instruction::toString).toArray(String[]::new);
    }

    public Parser process() {
        SymbolTable table = new SymbolTable();

        Map<Boolean, List<Instruction>> collect = instructions.stream().collect(Collectors.partitioningBy(i -> i instanceof LInstruction));
        collect.get(true).forEach(i -> i.process(table));
        collect.get(false).forEach(i -> i.process(table));

        instructions = new ArrayList<Instruction>(collect.get(false));
        return this;
    }

    public Parser parseLines(String[] lines) {
        ArrayList<Instruction> instructions = new ArrayList<>();
        int address = 0;

        for (String line : lines) {
            Instruction instruction = parseLine(line, address);
            instructions.add(instruction);

            if (!(instruction instanceof LInstruction)) {
                address++;
            }
        }

        this.instructions = instructions;
        return this;
    }

    public Instruction parseLine(String line, int lineNumber) {
        if (line.startsWith("@")) {
            return new AInstruction(line.substring(1));
        } else if (line.startsWith("(") && line.endsWith(")")) {
            return new LInstruction(line.substring(1, line.length() - 1), lineNumber);
        } else {
            return new CInstruction(line);
        }
    }

    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }
}
