package org.evomaster.client.java.controller.internal.db;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectBody;
import net.sf.jsqlparser.statement.update.Update;

public class ParserUtils {


    public static boolean isSelect(String sql) {
        return startsWithIgnoreCase(sql, "select");
    }

    public static boolean isDelete(String sql) {
        return startsWithIgnoreCase(sql, "delete");
    }

    public static boolean isUpdate(String sql) {
        return startsWithIgnoreCase(sql, "update");
    }

    public static boolean isInsert(String sql) {
        return startsWithIgnoreCase(sql, "insert");
    }

    private static boolean startsWithIgnoreCase(String input, String prefix){
        return input!= null && input.trim().toLowerCase().startsWith(prefix);
    }


    public static Expression getWhere(Statement statement) {

        if(statement instanceof Select) {
            Select select = (Select) statement;
            SelectBody selectBody = select.getSelectBody();
            if (selectBody instanceof PlainSelect) {
                PlainSelect plainSelect = (PlainSelect) selectBody;
                return plainSelect.getWhere();
            }
        } else if(statement instanceof Delete){
            return ((Delete) statement).getWhere();
        } else if(statement instanceof Update){
            return ((Update) statement).getWhere();
        }

        throw new IllegalArgumentException("Cannot handle statement: " + statement.toString());
    }

    public static Statement asStatement(String statement) {
        Statement stmt;
        try {
            stmt = CCJSqlParserUtil.parse(statement);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid SQL statement: " + statement + "\n" + e.getMessage(), e);
        }
        return stmt;
    }
}
