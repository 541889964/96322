package com.example.deepseekpow;
import de.robv.android.xposed.*;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
public class MainHook implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("com.deepseek.chat")) return;
        XposedBridge.log(">>> DeepSeek Pow Hook 已注入 <<<");
        try {
            Class<?> c = XposedHelpers.findClass("com.deepseek.crypto.PowCalculator", lpparam.classLoader);
            XposedHelpers.findAndHookMethod(c, "calculateDeepSeekHashV1Pow", String.class, String.class, int.class, new XC_MethodHook() {
                @Override protected void beforeHookedMethod(MethodHookParam p) {
                    XposedBridge.log("--- PoW 参数 ---\nchallenge: " + p.args[0] + "\nsalt: " + p.args[1] + "\nint: " + p.args[2]);
                }
                @Override protected void afterHookedMethod(MethodHookParam p) {
                    XposedBridge.log("PoW 结果: " + p.getResult());
                }
            });
        } catch (Throwable t) { XposedBridge.log("Hook 错误: " + t.getMessage()); }
    }
}
