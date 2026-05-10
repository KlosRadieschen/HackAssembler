package Instruction;

import java.util.Map;

public class Code {
    private static final Map<String, Integer> COMP_TABLE = Map.ofEntries(
            Map.entry("0", 0b101010),
            Map.entry("1", 0b111111),
            Map.entry("-1", 0b111010),
            Map.entry("D", 0b001100),
            Map.entry("A", 0b110000),
            Map.entry("!D", 0b001101),
            Map.entry("!A", 0b110001),
            Map.entry("-D", 0b001111),
            Map.entry("-A", 0b110011),
            Map.entry("D+1", 0b011111),
            Map.entry("A+1", 0b110111),
            Map.entry("D-1", 0b001110),
            Map.entry("A-1", 0b110010),
            Map.entry("D+A", 0b000010),
            Map.entry("D-A", 0b010011),
            Map.entry("A-D", 0b000111),
            Map.entry("D&A", 0b000000),
            Map.entry("D|A", 0b010101)
    );

    private static final Map<String, Integer> DEST_TABLE = Map.ofEntries(
            Map.entry("M", 0b001),
            Map.entry("D", 0b010),
            Map.entry("DM", 0b011),
            Map.entry("A", 0b100),
            Map.entry("AM", 0b101),
            Map.entry("AD", 0b110),
            Map.entry("ADM", 0b111)
    );
    private static final Map<String, Integer> JUMP_TABLE = Map.ofEntries(
            Map.entry("JGT", 0b001),
            Map.entry("JEQ", 0b010),
            Map.entry("JGE", 0b011),
            Map.entry("JLT", 0b100),
            Map.entry("JNE", 0b101),
            Map.entry("JLE", 0b110),
            Map.entry("JMP", 0b111)
    );

    public static int translateComp(String comp) {
        int a = 0;
        if (comp.contains("M")) {
            a= (int) Math.pow(2, 6);
        }

        return COMP_TABLE.get(comp.replace("M", "A")) + a;
    }

    public static int translateDest(String dest) {
        if (dest == null) return 0;

        return DEST_TABLE.get(dest); // A = M for the translation
    }

    public static int translateJump(String jump) {
        if (jump == null) return 0;

        return JUMP_TABLE.get(jump); // A = M for the translation
    }
}
