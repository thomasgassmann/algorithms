package com.thomasgassmann.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinimumEditDistanceTests {
    @Test
    public void ChekMinimumEditDistance() {
        CheckVariety("TIGER", "ZIEGE");
        CheckVariety("ABCCCCC", "ABC");
        CheckVariety("IWANTTOKNOW", "KNOWWANTI");
    }

    public void CheckVariety(String from, String to) {
        var a = new MinimumEditDistance();
        var edits = a.MinimumEditDistance(from, to);
        int indexOffset = 0;
        for (var edit : edits) {
            var str = new StringBuilder(from);
            switch (edit.getEditType()) {
                case Delete:
                    var deleteEdit = (MinimumEditDistance.DeleteEdit)edit;
                    str.deleteCharAt(deleteEdit.getIndex() + indexOffset);
                    indexOffset--;
                    break;
                case Insert:
                    var insertEdit = (MinimumEditDistance.InsertEdit)edit;
                    str.insert(insertEdit.getIndex() + indexOffset, insertEdit.getCharacter());
                    indexOffset++;
                    break;
                case Replace:
                    var replaceEdit = (MinimumEditDistance.ReplaceEdit)edit;
                    str.setCharAt(replaceEdit.getIndex() + indexOffset, replaceEdit.getReplacement());
                    break;
                default:
                    break;
            }

            from = str.toString();
        }

        Assertions.assertEquals(from, to);
    }
}
