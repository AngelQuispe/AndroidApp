package com.example.juego;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private ImageView Casillero;
	int[] i={0,0,0,0,0,0,0,0,0};
	int jug=1;
	//TextView text=(TextView)findViewById(R.id.text1);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onClick(View v) {
		int z=v.getId();
		String a=v.getContentDescription().toString();
		int pos= Integer.parseInt(a);
		Casillero=(ImageView)findViewById(z);
		TextView text=(TextView)findViewById(R.id.text1);
		
        if (i[pos]==0 && jug==1){
    	Casillero.setImageResource(R.drawable.corazon);
    	text.setText("Jugador 2");
    	i[pos]=1;
    	ganador();
    	jug=2;}
    	else if(i[pos]==0 && jug==2){
        Casillero.setImageResource(R.drawable.espada);
        text.setText("Jugador 1");
        i[pos]=2;
        ganador();
        jug=1;}	
    	
    	
    }
	public void reset(View v){
		setContentView(R.layout.activity_main);
		for(int z=0;z<9;z++){i[z]=0;}
		jug=1;
	}
	public void ganador(){
		
		
		if (i[0]==i[4] && i[4]==i[8] && i[0]!=0){
			setContentView(R.layout.ganador);
			mostrar(i[0]);			
		}
		
		if (i[2]==i[4] && i[4]==i[6] && i[2]!=0){
			setContentView(R.layout.ganador);
			mostrar(i[2]);
		}
		
		for(int j=0; j<9; j=j+3){
			if(i[j]==i[j+1] && i[j+1]==i[j+2] && i[j]!=0){
				setContentView(R.layout.ganador);
				mostrar(i[j]);
			}
		}
		
		for(int x=0; x<3; x++){
			if(i[x]==i[x+3] && i[x+3]==i[x+6] && i[x]!=0){
				setContentView(R.layout.ganador);
				mostrar(i[x]);
			}
		}
	}
	
	public void mostrar(int t){
		TextView text;
		ImageView win;
	
		text=(TextView)findViewById(R.id.text2);
		text.setText("Gana el Jugador "+t);
		win=(ImageView)findViewById(R.id.winner);
		
		if(jug==1)
			win.setImageResource(R.drawable.corazon);
		else
			win.setImageResource(R.drawable.espada);
	}
}
