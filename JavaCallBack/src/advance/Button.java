package advance;

/**
 * Created by ryanhuenwork on 16-10-4.
 */
public class Button {
    OnClickListener mOnClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    public void performClick() {
        //这就是回调
        mOnClickListener.onClick();
    }
}
