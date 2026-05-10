package Instruction;

public final class LInstruction extends Instruction {
    private final String label;
    private final int address;

    public LInstruction(String label, int address) {
        this.label = label;
        this.address = address;
    }

    public void process(SymbolTable table) {
        table.add(label, address);
    }

    public String getLabel() {
        return label;
    }

    public int getAddress() {
        return address;
    }
}
