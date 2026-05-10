package Instruction;

public sealed interface Value permits ProcessedValue, UnprocessedValue {}

record ProcessedValue(int address) implements Value {}
record UnprocessedValue(String symbol) implements Value {}