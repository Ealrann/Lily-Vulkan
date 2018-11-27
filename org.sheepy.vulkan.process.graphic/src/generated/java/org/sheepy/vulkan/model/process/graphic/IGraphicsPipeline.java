/**
 */
package org.sheepy.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;

import org.sheepy.vulkan.model.process.IPipeline;

import org.sheepy.vulkan.model.resource.Shader;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IGraphics Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.IGraphicsPipeline#getShaders <em>Shaders</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.IGraphicsPipeline#getViewportState <em>Viewport State</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.IGraphicsPipeline#getRasterizer <em>Rasterizer</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.IGraphicsPipeline#getColorBlend <em>Color Blend</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.IGraphicsPipeline#getDynamicState <em>Dynamic State</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getIGraphicsPipeline()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IGraphicsPipeline extends IPipeline
{
	/**
	 * Returns the value of the '<em><b>Shaders</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.resource.Shader}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shaders</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shaders</em>' reference list.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getIGraphicsPipeline_Shaders()
	 * @model
	 * @generated
	 */
	EList<Shader> getShaders();

	/**
	 * Returns the value of the '<em><b>Viewport State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Viewport State</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Viewport State</em>' containment reference.
	 * @see #setViewportState(ViewportState)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getIGraphicsPipeline_ViewportState()
	 * @model containment="true"
	 * @generated
	 */
	ViewportState getViewportState();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.IGraphicsPipeline#getViewportState <em>Viewport State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Viewport State</em>' containment reference.
	 * @see #getViewportState()
	 * @generated
	 */
	void setViewportState(ViewportState value);

	/**
	 * Returns the value of the '<em><b>Rasterizer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rasterizer</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rasterizer</em>' containment reference.
	 * @see #setRasterizer(Rasterizer)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getIGraphicsPipeline_Rasterizer()
	 * @model containment="true"
	 * @generated
	 */
	Rasterizer getRasterizer();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.IGraphicsPipeline#getRasterizer <em>Rasterizer</em>}' containment reference.
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
	 * <p>
	 * If the meaning of the '<em>Color Blend</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Blend</em>' containment reference.
	 * @see #setColorBlend(ColorBlend)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getIGraphicsPipeline_ColorBlend()
	 * @model containment="true"
	 * @generated
	 */
	ColorBlend getColorBlend();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.IGraphicsPipeline#getColorBlend <em>Color Blend</em>}' containment reference.
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
	 * <p>
	 * If the meaning of the '<em>Dynamic State</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamic State</em>' containment reference.
	 * @see #setDynamicState(DynamicState)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getIGraphicsPipeline_DynamicState()
	 * @model containment="true"
	 * @generated
	 */
	DynamicState getDynamicState();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.IGraphicsPipeline#getDynamicState <em>Dynamic State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic State</em>' containment reference.
	 * @see #getDynamicState()
	 * @generated
	 */
	void setDynamicState(DynamicState value);

} // IGraphicsPipeline
