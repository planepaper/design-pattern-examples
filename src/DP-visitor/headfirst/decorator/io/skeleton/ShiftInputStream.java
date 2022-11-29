package headfirst.decorator.io.skeleton;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.IntFunction;

public class ShiftInputStream extends FilterInputStream {
  final int ALPHABET_SIZE = 26;
  private int _offset = 0;

  public ShiftInputStream(InputStream inputStream) {
    super(inputStream);
  }
  public ShiftInputStream(InputStream inputStream, int offset)
  {
    super(inputStream);
    _offset = offset % ALPHABET_SIZE ;
  }

  @Override
  public int read() throws IOException {
    int c = super.read();
    c = shiftalphabet(c);
    return ((c == -1) ? c : (char)c);
  }

  private int shiftalphabet(int alphabet){

    IntFunction isAlphabet = (a) -> (a >= 'a' && a<= 'z') || (a>='A' && a<='Z') ?  true :  false;

    if((boolean)isAlphabet.apply(alphabet))
    {
      alphabet += _offset;
      if(!(boolean)isAlphabet.apply(alphabet))
      {
        if(_offset < 0)
        {
          alphabet += ALPHABET_SIZE;
        }
        else if(_offset > 0)
        {
          alphabet -= ALPHABET_SIZE;
        }

      }
    }

    return alphabet;
  }


}
