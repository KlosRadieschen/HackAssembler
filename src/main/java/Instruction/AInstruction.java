package Instruction;

public final class AInstruction extends Instruction {
    private Value value;

    public AInstruction(String value) {
        try {
            this.value = new ProcessedValue(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            this.value = new UnprocessedValue(value);
        }
    }

    public void process(SymbolTable table) {
        if (value instanceof UnprocessedValue(String unprocessedValue)) {
            value = new ProcessedValue(table.getAddress(unprocessedValue));
        }
    }

    @Override
    public String toString() {
        if (value instanceof ProcessedValue(int v)) {
            return Instruction.toBinaryStringOfSize(v, 16);
        } else if (value instanceof UnprocessedValue(String v)) {
            return "@" + v;
        }
        return "";
    }
}
