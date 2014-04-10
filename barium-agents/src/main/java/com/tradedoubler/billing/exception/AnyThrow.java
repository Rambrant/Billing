package com.tradedoubler.billing.exception;

/**
 * @author Thomas Rambrant (thore)
 */

//
// This class enables us to throw any exception without having to declare any throw clauses.
// It's useful in the situation where we want to emulate the behaviour of lower level classes without
// being forced to change the interfaces...
//
// Look here for more info... http://blog.ragozin.info/2011/10/java-how-to-throw-undeclared-checked.html
//
public class AnyThrow
{
    public static void throwUnchecked( Throwable e)
    {
        AnyThrow.< RuntimeException>throwAny( e);
    }

    @SuppressWarnings("unchecked")
    private static < E extends Throwable> void throwAny( Throwable e) throws E
    {
        throw( E) e;
    }
}