package com.thomasgassmann.dp;

public class MinimumEditDistance {
    public enum EditType {
        Insert,
        Delete,
        Replace
    }

    public abstract class Edit {
        public abstract EditType getEditType();
    }

    public class InsertEdit extends Edit {
        private char _char;
        private int _index;

        public InsertEdit(char c, int i) {
            _char = c;
            _index = i;
        }

        public char getCharacter() {
            return _char;
        }

        public int getIndex() {
            return _index;
        }

        @Override
        public EditType getEditType() {
            return EditType.Insert;
        }
    }

    public class ReplaceEdit extends Edit {
        private char _original;
        private char _replacement;
        private int _index;

        public ReplaceEdit(char original, char replacement, int index) {
            _original = original;
            _replacement = replacement;
            _index = index;
        }

        public char getOriginal() {
            return _original;
        }

        public char getReplacement() {
            return _replacement;
        }

        public int getIndex() {
            return _index;
        }

        @Override
        public EditType getEditType() {
            return EditType.Replace;
        }
    }

    public class DeleteEdit extends Edit {
        private char _char;
        private int _index;

        public DeleteEdit(char character, int index) {
            _char = character;
            _index = index;
        }

        public char getCharacter() {
            return _char;
        }

        public int getIndex() {
            return _index;
        }

        @Override
        public EditType getEditType() {
            return EditType.Delete;
        }
    }

    public Edit[] MinimumEditDistance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        // init dp table
        // edit distance from string with length
        // i to empty string (0) is always i
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = i;
        for (int i = 0; i < dp[0].length; i++)
            dp[0][i] = i;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int delta = a.charAt(i - 1) == b.charAt(j - 1) ? 1 : 0;
                dp[i][j] = Math.min(
                        dp[i - 1][j] + 1, // delete last char of A' (step back in A)
                        Math.min(
                                dp[i][j - 1] + 1, // add char from B' to A' (step back in B)
                                dp[i - 1][j - 1] + 1     - delta // replace ai by bj (step back both)
                        )
                );
            }
        }

        int i = a.length();
        int j = b.length();
        var length = dp[i][j];
        var edits = new Edit[length];
        while (length > 0) {
            Edit edit = null;
            if (dp[i - 1][j] < dp[i][j]) {
                edit = new DeleteEdit(a.charAt(i - 1), i - 1);
                i--;
            } else if (dp[i][j - 1] < dp[i][j]) {
                edit = new InsertEdit(b.charAt(j - 1), i);
                j--;
            } else {
                if (dp[i - 1][j - 1] < dp[i][j]) {
                    edit = new ReplaceEdit(a.charAt(i - 1), b.charAt(j - 1), i - 1);
                }

                i--;
                j--;
            }

            if (edit != null) {
                edits[--length] = edit;
            }
        }

        return edits;
    }
}
