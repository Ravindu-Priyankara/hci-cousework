package org.ravindupriyankara;

/*
import javax.swing.*;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.glsl.ShaderCode;
import com.jogamp.opengl.util.glsl.ShaderProgram;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;
import com.jogamp.opengl.util.FPSAnimator;
import de.javagl.jgltf.impl.v2.Mesh;
import de.javagl.jgltf.model.*;
import de.javagl.jgltf.model.gl.*;
import de.javagl.jgltf.model.io.*;

import java.io.*;
import java.nio.*;
import java.util.*;

public class GLTFViewer extends JFrame implements GLEventListener {
    private GLCanvas canvas;
    private FPSAnimator animator;
    private Model gltfModel;

    public GLTFViewer() {
        setTitle("GLTF Viewer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas = new GLCanvas(new GLCapabilities(GLProfile.getDefault()));
        canvas.addGLEventListener(this);
        add(canvas);

        animator = new FPSAnimator(canvas, 60);
        animator.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GLTFViewer().setVisible(true);
        });
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        GL4 gl = drawable.getGL().getGL4();

        // Load GLTF model
        try {
            gltfModel = GltfModels.read(new File("path/to/your/model.gltf"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Compile shaders
        int vertexShader = compileShader(gl, GL4.GL_VERTEX_SHADER, "vertexShader.glsl");
        int fragmentShader = compileShader(gl, GL4.GL_FRAGMENT_SHADER, "fragmentShader.glsl");

        // Link shader program
        int shaderProgram = gl.glCreateProgram();
        gl.glAttachShader(shaderProgram, vertexShader);
        gl.glAttachShader(shaderProgram, fragmentShader);
        gl.glLinkProgram(shaderProgram);
        gl.glUseProgram(shaderProgram);

        // Set up vertex data buffers
        List<Mesh> meshes = gltfModel.getMeshes();
        // Iterate over meshes and set up vertex buffer objects (VBOs) and vertex array objects (VAOs)
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL4 gl = drawable.getGL().getGL4();

        // Clear the screen
        gl.glClear(GL4.GL_COLOR_BUFFER_BIT | GL4.GL_DEPTH_BUFFER_BIT);

        // Render the GLTF model
        List<Mesh> meshes = gltfModel.getMeshes();
        for (Mesh mesh : meshes) {
            // Bind vertex array object (VAO) and draw elements
        }
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        // Clean up resources
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        // Handle window resizing
    }

    private int compileShader(GL4 gl, int type, String shaderFile) {
        // Load and compile shader code from file
        ShaderCode shaderCode = ShaderCode.create(gl, type, this.getClass(), "", "", shaderFile, true);
        ShaderProgram shaderProgram = new ShaderProgram();
        shaderProgram.add(shaderCode);
        shaderProgram.init(gl);

        return shaderProgram.program();
    }
}


 */
