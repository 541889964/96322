package com.example.deepseekpow;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.materialswitch.MaterialSwitch;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvStatus = findViewById(R.id.tvStatus);
        MaterialSwitch switchLog = findViewById(R.id.switchLog);
        MaterialButton btnTest = findViewById(R.id.btnTest);

        // 模拟状态更新
        tvStatus.postDelayed(() -> {
            tvStatus.setText("版本: 1.1\n注入目标: DeepSeek (com.deepseek.chat)\n运行状态: ✅ Hook 已就绪");
        }, 1000);

        btnTest.setOnClickListener(v -> {
            Toast.makeText(this, "测试信号已发送！请查看 LSPosed 日志。", Toast.LENGTH_SHORT).show();
        });
    }
}
