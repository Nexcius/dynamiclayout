package schibsted.com.dynamiclayout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import schibsted.com.dynamiclayout.models.ComponentData;
import schibsted.com.dynamiclayout.models.LayoutData;
import schibsted.com.dynamiclayout.util.CachedImageHandler;
import schibsted.com.dynamiclayout.util.ComponentResolver;
import schibsted.com.dynamiclayout.util.LayoutDownloader;
import schibsted.com.dynamiclayout.util.OnLayoutUpdateListener;

public class DynamicLayout extends AppCompatActivity implements OnLayoutUpdateListener {
    private Toolbar toolbar;
    private LinearLayout layout;
    private CachedImageHandler imageCache = new CachedImageHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.layout = (LinearLayout)findViewById(R.id.app_content);

        setSupportActionBar(this.toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if(fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new LayoutDownloader(DynamicLayout.this).execute("http://pastebin.com/raw/mtE4rkb5");
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void OnLayoutUpdate(LayoutData layoutData) {
        layout.removeAllViews();

        if(layoutData != null) {
            if(layoutData.title != null) {
                toolbar.setTitle(layoutData.title);
            }

            if(layoutData.components != null) {
                for(ComponentData c: layoutData.components) {
                    ComponentResolver.addComponent(this, layout, c, imageCache);
                }
            }
        }

        Snackbar.make(layout, "Layout updated", Snackbar.LENGTH_LONG).show();
    }
}
