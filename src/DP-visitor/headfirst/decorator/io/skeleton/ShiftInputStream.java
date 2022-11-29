package headfirst.decorator.io.skeleton;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ShiftInputStream extends FilterInputStream {

  private int _offset = 0;

  public ShiftInputStream(InputStream inputStream) {
    super(inputStream);
  }
  public ShiftInputStream(InputStream inputStream, int offset)
  {
    super(inputStream);
    _offset = offset;
  }

  @Override
  public int read() throws IOException {
    int c = super.read();
    if((c >= 'a' && c<= 'z') || (c>='A' && c<='Z'))
    {
      c += _offset;
    }
    return ((c == -1) ? c : (char)c);
  }

  @Override
  public int read(byte[] b, int offset, int len) throws IOException {
    int result = super.read(b, offset, len);
    for (int i = offset; i < offset+result ; i++ )
      b[i] = (byte)Character.toLowerCase((char)b[i]);

    return result;
  }
}
