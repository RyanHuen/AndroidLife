package advance;

/**
 * Created by ryanhuenwork on 16-10-4.
 */
public class Activity implements OnClickListener {
    Button mButton;

    /**
     * 模拟Android的Activity中的onCreate()方法
     */
    public Activity(Button button) {
        //模拟findViewById()
        mButton = button;
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick() {
        System.out.println("按钮被点击了");
    }


    /**
     * 模拟Button点击
     */
    public void push() {
        mButton.performClick();
    }
}
