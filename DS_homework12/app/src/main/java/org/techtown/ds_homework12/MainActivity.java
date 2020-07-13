package org.techtown.ds_homework12;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "FinishedCourse.db", null, 1);

        // 테이블에 있는 모든 데이터 출력
        final TextView result = (TextView) findViewById(R.id.result);
        final EditText etGrade = (EditText) findViewById(R.id.grade);
        final EditText etSemester = (EditText) findViewById(R.id.semester);
        final EditText etName = (EditText) findViewById(R.id.name);
        final EditText etYear = (EditText) findViewById(R.id.year);

        // DB에 데이터 추가
        Button insert = (Button) findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int grade = Integer.parseInt(etGrade.getText().toString());
                int semester = Integer.parseInt(etSemester.getText().toString());
                String name = etName.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());

                dbHelper.insert(grade, semester, name, year);   //*
                result.setText(dbHelper.getResult());
            }
        });

        // DB에 있는 데이터 삭제
        Button delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();

                dbHelper.delete(name);
                result.setText(dbHelper.getResult());
            }
        });

        // DB에 있는 데이터 조회
        Button select = (Button) findViewById(R.id.select);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(dbHelper.getResult());
            }
        });

    }
}

class DBHelper extends SQLiteOpenHelper {

    // DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // DB를 새로 생성할 때 호출되는 함수
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 새로운 테이블 생성
        /* 이름은 FinishedCourse이고, 자동으로 값이 증가하는 _id 정수형 기본키 컬럼과
        grade 정수형 컬럼, semester 정수형 컬럼, name 문자열 컬럼, year 정수형 컬럼으로 구성된 테이블을 생성. */
        db.execSQL("CREATE TABLE FinishedCourse (_id INTEGER PRIMARY KEY AUTOINCREMENT,grade INTEGER,semester INTEGER,name TEXT,year INTEGER);");
    }

    // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(int grade, int semester, String name, int year) {
        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getWritableDatabase();
        // DB에 입력한 값으로 행 추가
        db.execSQL("INSERT INTO FinishedCourse VALUES(null,'"+grade+"','"+semester+"','"+name+"','"+year+"');");
        db.close();
    }

    public void delete(String name) {
        SQLiteDatabase db = getWritableDatabase();
        // 입력한 항목과 일치하는 행 삭제
        db.execSQL("DELETE FROM FinishedCourse WHERE name='" + name + "');");
        db.close();
    }

    public String getResult() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM FinishedCourse",null);
        while (cursor.moveToNext()) {
            result += cursor.getInt(0)
                    + " . 학년: "
                    + cursor.getInt(1)
                    + " 학기: "
                    + cursor.getInt(2)
                    + " 과목명: "
                    + cursor.getString(3)
                    + " 이수년도: "
                    + cursor.getInt(4)
                    + "\n";
        }

        return result;
    }
}