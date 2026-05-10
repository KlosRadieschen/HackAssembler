package Instruction;

public abstract sealed class Instruction
permits AInstruction, CInstruction, LInstruction {
    public abstract void process(SymbolTable table);

    public static String toBinaryStringOfSize(int num, int size) {
        return String.format("%" + size + "s", Integer.toBinaryString(num))
                .replace(' ', '0');
    }
}
