package ndj.daro.radiotu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ProgramacionActivity extends Activity {
    private String [] prograTitles;
    private String [] prograDesc;
    private String [] prograHora;

    private Integer[] imgid={
            R.drawable.alarmanitro_thumb,
            R.drawable.sintiempo_thumb,
            R.drawable.nitroclub_thumb,
            R.drawable.lavuelta_thumb,
            R.drawable.trending_thumb,
            R.drawable.lamesa_thumb,
            R.drawable.djnitro_thumb,
            R.drawable.zona_thumb,
            R.drawable.quedamucho_thumb,
            R.drawable.valetodo_thumb,
            R.drawable.recreo_thumb
    };

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programacion);
        prograTitles = getResources().getStringArray(R.array.titles);
        prograDesc = getResources().getStringArray(R.array.desc);
        prograHora = getResources().getStringArray(R.array.horarios);

        ProgramacionListAdapter adapter=new ProgramacionListAdapter(this,prograTitles, prograDesc, prograHora,imgid);
        lista = findViewById(R.id.programacion_lista);
        lista.setAdapter(adapter);

    }
}
