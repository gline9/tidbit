/* Generated By:JavaCC: Do not edit this line. TidBit.java */
package tidbit.ast;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;


public class TidBit implements TidBitConstants {
        public static Root parse(InputStream input) throws ParseException, IOException
        {
                return new TidBit(input).Program();
        }

  static final public Root Program() throws ParseException {
        List<CodeGeneratingNode> nodes = null;
    nodes = StatementList();
                {if (true) return new Root(nodes);}
    throw new Error("Missing return statement in function");
  }

  static final public List<CodeGeneratingNode> StatementList() throws ParseException {
        List<CodeGeneratingNode> nodes = new ArrayList<CodeGeneratingNode>();
        CodeGeneratingNode node = null;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PRINT:
      case IF:
      case VARIABLE_NAME:
      case 20:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      node = Statement();
                nodes.add(node);
    }
                {if (true) return nodes;}
    throw new Error("Missing return statement in function");
  }

  static final public CodeGeneratingNode Statement() throws ParseException {
        CodeGeneratingNode ret = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PRINT:
    case IF:
    case VARIABLE_NAME:
      ret = SimpleStatement();
      break;
    case 20:
      ret = ScopeStatement();
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
                {if (true) return ret;}
    throw new Error("Missing return statement in function");
  }

  static final public Scope ScopeStatement() throws ParseException {
        List<CodeGeneratingNode> nodes = null;
    jj_consume_token(20);
    nodes = StatementList();
    jj_consume_token(21);
                {if (true) return new Scope(nodes);}
    throw new Error("Missing return statement in function");
  }

  static final public CodeGeneratingNode SimpleStatement() throws ParseException {
        CodeGeneratingNode ret = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PRINT:
    case VARIABLE_NAME:
      ret = Expression();
      jj_consume_token(SEMICOLON);
      break;
    case IF:
      ret = IfStatement();
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
                {if (true) return ret;}
    throw new Error("Missing return statement in function");
  }

  static final public CodeGeneratingNode IfStatement() throws ParseException {
        Scope scope = null;
        Value value = null;
    jj_consume_token(IF);
    jj_consume_token(LPAREN);
    value = Value();
    jj_consume_token(RPAREN);
    scope = ScopeStatement();
                {if (true) return new IfStatement(value, scope);}
    throw new Error("Missing return statement in function");
  }

  static final public CodeGeneratingNode Expression() throws ParseException {
        CodeGeneratingNode ret = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PRINT:
      ret = PrintExpr();
      break;
    case VARIABLE_NAME:
      ret = AssignmentStatement();
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
                {if (true) return ret;}
    throw new Error("Missing return statement in function");
  }

  static final public PrintStatement PrintExpr() throws ParseException {
    Value value = null;
    jj_consume_token(PRINT);
    jj_consume_token(LPAREN);
    value = Value();
    jj_consume_token(RPAREN);
                {if (true) return new PrintStatement(value);}
    throw new Error("Missing return statement in function");
  }

  static final public AssignmentStatement AssignmentStatement() throws ParseException {
        Token name = null;
        Value value = null;
    name = jj_consume_token(VARIABLE_NAME);
    jj_consume_token(EQUALS);
    value = Value();
                {if (true) return new AssignmentStatement(name.image, value);}
    throw new Error("Missing return statement in function");
  }

  static final public Value Value() throws ParseException {
    Value ret = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STRING_LITERAL:
      ret = StringValue();
      break;
    case INTEGER_LITERAL:
    case LPAREN:
    case VARIABLE_NAME:
      ret = AddExpression();
      break;
    case TRUE:
    case FALSE:
      ret = BooleanValue();
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
                {if (true) return ret;}
    throw new Error("Missing return statement in function");
  }

  static final public BooleanValue BooleanValue() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TRUE:
      jj_consume_token(TRUE);
                {if (true) return new BooleanValue(true);}
      break;
    case FALSE:
      jj_consume_token(FALSE);
                {if (true) return new BooleanValue(false);}
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public StringValue StringValue() throws ParseException {
    Token value = null;
    value = jj_consume_token(STRING_LITERAL);
        String image = value.image;
                {if (true) return new StringValue(image.substring(1, image.length() - 1));}
    throw new Error("Missing return statement in function");
  }

  static final public Value AddExpression() throws ParseException {
        Value left = null;
        Value rightAcc = null;
        Value right = null;
    left = MultExpression();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_2;
      }
      jj_consume_token(PLUS);
      right = MultExpression();
                        if (null == rightAcc)
                        {
                                rightAcc = right;
                        }
                        else
                        {
                                rightAcc = new AddExpression(rightAcc, right);
                        }
    }
                if (null == rightAcc)
                {
                        {if (true) return left;}
                }

                {if (true) return new AddExpression(left, rightAcc);}
    throw new Error("Missing return statement in function");
  }

  static final public Value MultExpression() throws ParseException {
        Value left = null;
        Value rightAcc = null;
        Value right = null;
    left = ModExpression();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ASTERISKS:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_3;
      }
      jj_consume_token(ASTERISKS);
      right = ModExpression();
                        if (null == rightAcc)
                        {
                                rightAcc = right;
                        }
                        else
                        {
                                rightAcc = new MultExpression(rightAcc, right);
                        }
    }
                if (null == rightAcc)
                {
                        {if (true) return left;}
                }

                {if (true) return new MultExpression(left, rightAcc);}
    throw new Error("Missing return statement in function");
  }

  static final public Value ModExpression() throws ParseException {
        Value left = null;
        Value rightAcc = null;
        Value right = null;
    left = GroupExpression();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PERCENT:
        ;
        break;
      default:
        jj_la1[8] = jj_gen;
        break label_4;
      }
      jj_consume_token(PERCENT);
      right = GroupExpression();
                        if (null == rightAcc)
                        {
                                rightAcc = right;
                        }
                        else
                        {
                                rightAcc = new ModExpression(rightAcc, right);
                        }
    }
                if (null == rightAcc)
                {
                        {if (true) return left;}
                }

                {if (true) return new ModExpression(left, rightAcc);}
    throw new Error("Missing return statement in function");
  }

  static final public Value GroupExpression() throws ParseException {
        Value value = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LPAREN:
      jj_consume_token(LPAREN);
      value = Value();
      jj_consume_token(RPAREN);
                {if (true) return value;}
      break;
    case INTEGER_LITERAL:
    case VARIABLE_NAME:
      value = NumberValue();
                {if (true) return value;}
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public Value NumberValue() throws ParseException {
        Token value = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER_LITERAL:
      value = jj_consume_token(INTEGER_LITERAL);
                {if (true) return new NumberValue(value.image);}
      break;
    case VARIABLE_NAME:
      value = jj_consume_token(VARIABLE_NAME);
                {if (true) return new VariableValue(value.image);}
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public TidBitTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[11];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x180300,0x180300,0x80300,0x80100,0x81cc0,0xc00,0x10000,0x8000,0x20000,0x81080,0x80080,};
   }

  /** Constructor with InputStream. */
  public TidBit(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public TidBit(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new TidBitTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public TidBit(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new TidBitTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public TidBit(TidBitTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(TidBitTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[22];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 11; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 22; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
