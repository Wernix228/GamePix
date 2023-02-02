package other;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Animation extends ApplicationAdapter {
    ShapeRenderer shapeRenderer;

    float circleX = 333;
    float circleY = 100;

    float xSpeed = 8;
    float ySpeed = 4;

    @Override
    public void create () {
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void render () {

        circleX += xSpeed;
        circleY += ySpeed;

        if(circleX < 0 || circleX > Gdx.graphics.getWidth()){
            xSpeed *= -1;
        }

        if(circleY < 0 || circleY > Gdx.graphics.getHeight()){
            ySpeed *= -1;
        }

        Gdx.gl.glClearColor(.0f, .0f, .0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(0, 1, 0, 1);
        shapeRenderer.circle(circleX, circleY, 40);
        shapeRenderer.end();
    }

    @Override
    public void dispose () {
        shapeRenderer.dispose();
    }
}