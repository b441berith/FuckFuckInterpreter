package com.fuckfuck.translator;

import java.util.HashMap;
import java.util.Map;

import com.brainfuck.operations.BrainfuckOperation;
import com.brainfuck.operations.DecrementCurrentDataPointerCellValueOperation;
import com.brainfuck.operations.DecrementDataPointerOperation;
import com.brainfuck.operations.EndLoopOperation;
import com.brainfuck.operations.IncrementCurrentDataPointerCellValueOperation;
import com.brainfuck.operations.IncrementDataPointerOperation;
import com.brainfuck.operations.PrintCurrentDataCellValue;
import com.brainfuck.operations.SetDataCellValueFromInputStreamOperation;
import com.brainfuck.operations.StartLoopOperation;
import com.fuckfuck.operations.FuckFuckOperationNames;

/**
 * FuckFuck language translator which also acts as a fuckfuck decompiler.
 * Translates fuckfuck source code to Brainfuck program
 *
 * User: ashuiskov
 * Date: 03/04/2012
 * Time: 18:57
 */
public class FuckFuckTranslatorBiMap {
    private static final Map<String, BrainfuckOperation> operationsMap = new HashMap<String, BrainfuckOperation>()
    {
        {
            put(FuckFuckOperationNames.TITS, new DecrementCurrentDataPointerCellValueOperation());
            put(FuckFuckOperationNames.SHAG, new DecrementDataPointerOperation());
            put(FuckFuckOperationNames.BUTT, new EndLoopOperation());
            put(FuckFuckOperationNames.BOOB, new IncrementCurrentDataPointerCellValueOperation());
            put(FuckFuckOperationNames.FUCK, new IncrementDataPointerOperation());
            put(FuckFuckOperationNames.COCK, new PrintCurrentDataCellValue());
            put(FuckFuckOperationNames.KNOB, new SetDataCellValueFromInputStreamOperation());
            put(FuckFuckOperationNames.ARSE, new StartLoopOperation());
        }
    };

    private static final Map<Class<? extends BrainfuckOperation>, String> reverseOperationsMap = new HashMap<Class<? extends BrainfuckOperation>, String>() {
        {
            put(DecrementCurrentDataPointerCellValueOperation.class, FuckFuckOperationNames.TITS);
            put(DecrementDataPointerOperation.class, FuckFuckOperationNames.SHAG);
            put(EndLoopOperation.class, FuckFuckOperationNames.BUTT);
            put(IncrementCurrentDataPointerCellValueOperation.class, FuckFuckOperationNames.BOOB);
            put(IncrementDataPointerOperation.class, FuckFuckOperationNames.FUCK);
            put(PrintCurrentDataCellValue.class, FuckFuckOperationNames.COCK);
            put(SetDataCellValueFromInputStreamOperation.class, FuckFuckOperationNames.KNOB);
            put(StartLoopOperation.class, FuckFuckOperationNames.ARSE);
        }
    };

    public static final BrainfuckOperation createOperation(String operationCode) {
        if (operationsMap.containsKey(operationCode)) {
            return operationsMap.get(operationCode);
        } else {
            return null;
        }
    }

    public static final String getOperatonCode(BrainfuckOperation operation) {
        return reverseOperationsMap.get(operation.getClass());
    }
}
