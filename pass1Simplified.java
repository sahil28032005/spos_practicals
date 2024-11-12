import java.util.*;
//cf solve
public class pass1Simplified {
    // superGlobals array whihc container symbol table ingotmation and inetmedaite
    // code
    Map<String, Integer> symbolTable = new HashMap<>();
    List<String> intermediateCode = new ArrayList<>();
    int locationCounter = 0;
//git conflicts removal checlkppoint
    // pass one stage method
    void passOne(String[] sourceCode) {
        // get line by line code
        for (String line : sourceCode) {
            String[] labeledInstructions = line.split(":");
            String label = labeledInstructions[0].trim();
            symbolTable.put(label, locationCounter);

            // process instruction part if avalieble
            if (labeledInstructions.length > 1) {
               //means instructon also present
               String instructionPart=labeledInstructions[1].trim();
               //add
               //increment location counter
               //done
            }
        }
    }

    public void printSymbolTable() {
        System.out.println(symbolTable);
    }

    public void printIntermediateCode() {
        System.out.println(intermediateCode);
    }

    public static void main(String args[]) {
        String[] sourceCode = {
                "START",
                "LOOP: LOAD A",
                "ADD B",
                "STORE C",
                "END"
        };

        pass1Simplified ps1 = new pass1Simplified();
        ps1.passOne(sourceCode); // sent source code to pass 1
        ps1.printIntermediateCode();
        ps1.printSymbolTable();

    }
}
