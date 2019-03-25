/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.vulkan.model.process.AbstractPipeline;

import org.sheepy.lily.vulkan.model.resource.Shader;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Graphics Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getShaders <em>Shaders</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getViewportState <em>Viewport State</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getRasterizer <em>Rasterizer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getColorBlend <em>Color Blend</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getDynamicState <em>Dynamic State</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getSubpass <em>Subpass</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAbstractGraphicsPipeline()
 * @model abstract="true"
 * @generated
 */
public interface AbstractGraphicsPipeline extends AbstractPipeline, IGraphicsPipeline
{
	/**
	 * Returns the value of the '<em><b>Shaders</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.resource.Shader}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shaders</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAbstractGraphicsPipeline_Shaders()
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
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAbstractGraphicsPipeline_ViewportState()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ViewportState getViewportState();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getViewportState <em>Viewport State</em>}' containment reference.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rasterizer</em>' containment reference.
	 * @see #setRasterizer(Rasterizer)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAbstractGraphicsPipeline_Rasterizer()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Rasterizer getRasterizer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getRasterizer <em>Rasterizer</em>}' containment reference.
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
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAbstractGraphicsPipeline_ColorBlend()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ColorBlend getColorBlend();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getColorBlend <em>Color Blend</em>}' containment reference.
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
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAbstractGraphicsPipeline_DynamicState()
	 * @model containment="true"
	 * @generated
	 */
	DynamicState getDynamicState();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getDynamicState <em>Dynamic State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic State</em>' containment reference.
	 * @see #getDynamicState()
	 * @generated
	 */
	void setDynamicState(DynamicState value);

	/**
	 * Returns the value of the '<em><b>Subpass</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subpass</em>' attribute.
	 * @see #setSubpass(int)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAbstractGraphicsPipeline_Subpass()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getSubpass();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getSubpass <em>Subpass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subpass</em>' attribute.
	 * @see #getSubpass()
	 * @generated
	 */
	void setSubpass(int value);

} // AbstractGraphicsPipeline
