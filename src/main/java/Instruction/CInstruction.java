package Instruction;

public final class CInstruction extends Instruction {
    private Value comp;
    private Value dest;
    private Value jump;

    public CInstruction(String instruction) {
        String[] parts = instruction.split("[=;]");

        if (instruction.contains("=") && instruction.contains(";")) {
            dest = new UnprocessedValue(parts[0]);
            comp = new UnprocessedValue(parts[1]);
            jump = new UnprocessedValue(parts[2]);
        } else if (instruction.contains("=")) {
            dest = new UnprocessedValue(parts[0]);
            comp = new UnprocessedValue(parts[1]);
        } else if (instruction.contains(";")) {
            comp = new UnprocessedValue(parts[0]);
            jump = new UnprocessedValue(parts[1]);
        }
    }
    public void process(SymbolTable table) {
        if (comp != null && comp instanceof UnprocessedValue(String unprocessedValue)) {
            comp = new ProcessedValue(Code.translateComp(unprocessedValue));
        } else if (comp == null) {
            comp = new ProcessedValue(0);
        }

        if (dest != null && dest instanceof UnprocessedValue(String unprocessedValue)) {
            dest = new ProcessedValue(Code.translateDest(unprocessedValue));
        } else if (dest == null) {
            dest = new ProcessedValue(0);
        }

        if (jump != null && jump instanceof UnprocessedValue(String unprocessedValue)) {
            jump = new ProcessedValue(Code.translateJump(unprocessedValue));
        } else if (jump == null) {
            jump = new ProcessedValue(0);
        }
    }

    public Value getComp() {
        return comp;
    }

    public Value getDest() {
        return dest;
    }

    public Value getJump() {
        return jump;
    }

    public void setComp(Value com) {
        comp = com;
    }

    public void setDest(Value des) {
        dest = des;
    }

    public void setJump(Value jum) {
        jump = jum;
    }

    @Override
    public String toString() {
        if (comp instanceof ProcessedValue(int c) && dest instanceof ProcessedValue(int d) && jump instanceof ProcessedValue(int j)) {
            return "111" + Instruction.toBinaryStringOfSize(c, 7) + Instruction.toBinaryStringOfSize(d, 3) + Instruction.toBinaryStringOfSize(j, 3) ;
        } else if (comp instanceof UnprocessedValue(String v) && dest instanceof UnprocessedValue(String d) && jump instanceof UnprocessedValue(String j)) {
            return d + "=" + v + ";" + j;
        }
        return "";
    }
}
