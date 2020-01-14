/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.vulkan.model.process.IVkPipeline;
import org.sheepy.lily.vulkan.model.resource.Shader;

import org.sheepy.vulkan.model.graphicpipeline.ColorBlend;
import org.sheepy.vulkan.model.graphicpipeline.DepthStencilState;
import org.sheepy.vulkan.model.graphicpipeline.DynamicState;
import org.sheepy.vulkan.model.graphicpipeline.InputAssembly;
import org.sheepy.vulkan.model.graphicpipeline.Rasterizer;
import org.sheepy.vulkan.model.graphicpipeline.ViewportState;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graphics Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getShaders <em>Shaders</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getViewportState <em>Viewport State</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getInputAssembly <em>Input Assembly</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getRasterizer <em>Rasterizer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getColorBlend <em>Color Blend</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getDynamicState <em>Dynamic State</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getVertexInputState <em>Vertex Input State</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getDepthStencilState <em>Depth Stencil State</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicsPipeline()
 * @model
 * @generated
 */
public interface GraphicsPipeline extends IVkPipeline, Maintainable<GraphicsPipeline>
{
	/**
	 * Returns the value of the '<em><b>Shaders</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.resource.Shader}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shaders</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicsPipeline_Shaders()
	 * @model required="true"
	 * @generated
	 */
	EList<Shader> getShaders();

	/**
	 * Returns the value of the '<em><b>Viewport State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Viewport State</em>' containment reference.
	 * @see #setViewportState(ViewportState)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicsPipeline_ViewportState()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ViewportState getViewportState();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getViewportState <em>Viewport State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Viewport State</em>' containment reference.
	 * @see #getViewportState()
	 * @generated
	 */
	void setViewportState(ViewportState value);

	/**
	 * Returns the value of the '<em><b>Input Assembly</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Assembly</em>' containment reference.
	 * @see #setInputAssembly(InputAssembly)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicsPipeline_InputAssembly()
	 * @model containment="true" required="true"
	 * @generated
	 */
	InputAssembly getInputAssembly();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getInputAssembly <em>Input Assembly</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Assembly</em>' containment reference.
	 * @see #getInputAssembly()
	 * @generated
	 */
	void setInputAssembly(InputAssembly value);

	/**
	 * Returns the value of the '<em><b>Rasterizer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rasterizer</em>' containment reference.
	 * @see #setRasterizer(Rasterizer)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicsPipeline_Rasterizer()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Rasterizer getRasterizer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getRasterizer <em>Rasterizer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rasterizer</em>' containment reference.
	 * @see #getRasterizer()
	 * @generated
	 */
	void setRasterizer(Rasterizer value);

	/**
	 * Returns the value of the '<em><b>Color Blend</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Blend</em>' containment reference.
	 * @see #setColorBlend(ColorBlend)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicsPipeline_ColorBlend()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ColorBlend getColorBlend();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getColorBlend <em>Color Blend</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Blend</em>' containment reference.
	 * @see #getColorBlend()
	 * @generated
	 */
	void setColorBlend(ColorBlend value);

	/**
	 * Returns the value of the '<em><b>Dynamic State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamic State</em>' containment reference.
	 * @see #setDynamicState(DynamicState)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicsPipeline_DynamicState()
	 * @model containment="true"
	 * @generated
	 */
	DynamicState getDynamicState();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getDynamicState <em>Dynamic State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic State</em>' containment reference.
	 * @see #getDynamicState()
	 * @generated
	 */
	void setDynamicState(DynamicState value);

	/**
	 * Returns the value of the '<em><b>Vertex Input State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertex Input State</em>' containment reference.
	 * @see #setVertexInputState(VertexInputState)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicsPipeline_VertexInputState()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VertexInputState getVertexInputState();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getVertexInputState <em>Vertex Input State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertex Input State</em>' containment reference.
	 * @see #getVertexInputState()
	 * @generated
	 */
	void setVertexInputState(VertexInputState value);

	/**
	 * Returns the value of the '<em><b>Depth Stencil State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth Stencil State</em>' containment reference.
	 * @see #setDepthStencilState(DepthStencilState)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicsPipeline_DepthStencilState()
	 * @model containment="true"
	 * @generated
	 */
	DepthStencilState getDepthStencilState();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getDepthStencilState <em>Depth Stencil State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth Stencil State</em>' containment reference.
	 * @see #getDepthStencilState()
	 * @generated
	 */
	void setDepthStencilState(DepthStencilState value);

} // GraphicsPipeline
