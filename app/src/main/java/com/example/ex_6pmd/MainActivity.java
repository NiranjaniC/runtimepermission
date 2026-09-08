package com.example.ex_6pmd;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final int CAMERA_REQUEST = 100;
    private static final int STORAGE_REQUEST = 200;

    private TextView statusText;
    private TextView cameraStatus;
    private TextView storageStatus;

    private Button cameraButton;
    private Button storageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        statusText = findViewById(R.id.statusText);
        cameraStatus = findViewById(R.id.cameraStatus);
        storageStatus = findViewById(R.id.storageStatus);

        cameraButton = findViewById(R.id.cameraButton);
        storageButton = findViewById(R.id.storageButton);

        updateStatus();

        cameraButton.setOnClickListener(view -> requestCamera());

        storageButton.setOnClickListener(view -> requestStorage());
    }

    private void requestCamera() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (checkSelfPermission(
                    Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(
                        new String[]{
                                Manifest.permission.CAMERA
                        },
                        CAMERA_REQUEST
                );

            } else {

                statusText.setText(
                        "Camera permission already granted ✓"
                );
            }
        }
    }

    private void requestStorage() {

        String permission;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

            permission = Manifest.permission.READ_MEDIA_IMAGES;

        } else {

            permission = Manifest.permission.READ_EXTERNAL_STORAGE;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (checkSelfPermission(permission)
                    != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(
                        new String[]{permission},
                        STORAGE_REQUEST
                );

            } else {

                statusText.setText(
                        "Storage permission already granted ✓"
                );
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            String[] permissions,
            int[] grantResults) {

        super.onRequestPermissionsResult(
                requestCode,
                permissions,
                grantResults
        );

        if (grantResults.length > 0 &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            if (requestCode == CAMERA_REQUEST) {

                statusText.setText(
                        "Camera permission granted ✓"
                );

            } else if (requestCode == STORAGE_REQUEST) {

                statusText.setText(
                        "Storage permission granted ✓"
                );
            }

        } else {

            statusText.setText(
                    "Permission denied ✕"
            );
        }

        updateStatus();
    }

    private void updateStatus() {

        boolean cameraGranted =
                checkSelfPermission(
                        Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED;

        if (cameraGranted) {

            cameraStatus.setText(
                    "✓ Camera permission granted"
            );

            cameraButton.setText(
                    "Camera Permission Granted"
            );

        } else {

            cameraStatus.setText(
                    "● Camera permission required"
            );

            cameraButton.setText(
                    "Allow Camera"
            );
        }

        String storagePermission;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

            storagePermission =
                    Manifest.permission.READ_MEDIA_IMAGES;

        } else {

            storagePermission =
                    Manifest.permission.READ_EXTERNAL_STORAGE;
        }

        boolean storageGranted =
                checkSelfPermission(
                        storagePermission
                ) == PackageManager.PERMISSION_GRANTED;

        if (storageGranted) {

            storageStatus.setText(
                    "✓ Storage / Media permission granted"
            );

            storageButton.setText(
                    "Storage Permission Granted"
            );

        } else {

            storageStatus.setText(
                    "● Storage permission required"
            );

            storageButton.setText(
                    "Allow Storage"
            );
        }

        if (cameraGranted && storageGranted) {

            statusText.setText(
                    "All permissions secured ✓"
            );

        } else {

            statusText.setText(
                    "Ready to request permission"
            );
        }
    }
}
