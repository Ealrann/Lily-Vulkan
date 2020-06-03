/**
 */
package org.sheepy.vulkan.model.graphicpipeline;

import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.vulkan.model.enumeration.ECullMode;
import org.sheepy.vulkan.model.enumeration.EFrontFace;
import org.sheepy.vulkan.model.enumeration.EPolygonMode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rasterizer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer#getCullMode <em>Cull Mode</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer#getFrontFace <em>Front Face</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer#getPolygonMode <em>Polygon Mode</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer#getLineWidth <em>Line Width</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer#isDepthClampEnable <em>Depth Clamp Enable</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer#isDiscardEnable <em>Discard Enable</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer#isDepthBiasEnable <em>Depth Bias Enable</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getRasterizer()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface Rasterizer extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Cull Mode</b></em>' attribute.
	 * The default value is <code>"BACK_BIT"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.ECullMode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cull Mode</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ECullMode
	 * @see #setCullMode(ECullMode)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getRasterizer_CullMode()
	 * @model default="BACK_BIT" unique="false"
	 * @generated
	 */
	ECullMode getCullMode();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer#getCullMode <em>Cull Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cull Mode</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ECullMode
	 * @see #getCullMode()
	 * @generated
	 */
	void setCullMode(ECullMode value);

	/**
	 * Returns the value of the '<em><b>Front Face</b></em>' attribute.
	 * The default value is <code>"CLOCKWISE"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EFrontFace}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Front Face</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EFrontFace
	 * @see #setFrontFace(EFrontFace)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getRasterizer_FrontFace()
	 * @model default="CLOCKWISE" unique="false"
	 * @generated
	 */
	EFrontFace getFrontFace();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer#getFrontFace <em>Front Face</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Front Face</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EFrontFace
	 * @see #getFrontFace()
	 * @generated
	 */
	void setFrontFace(EFrontFace value);

	/**
	 * Returns the value of the '<em><b>Polygon Mode</b></em>' attribute.
	 * The default value is <code>"FILL"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPolygonMode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Polygon Mode</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPolygonMode
	 * @see #setPolygonMode(EPolygonMode)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getRasterizer_PolygonMode()
	 * @model default="FILL" unique="false"
	 * @generated
	 */
	EPolygonMode getPolygonMode();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer#getPolygonMode <em>Polygon Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Polygon Mode</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPolygonMode
	 * @see #getPolygonMode()
	 * @generated
	 */
	void setPolygonMode(EPolygonMode value);

	/**
	 * Returns the value of the '<em><b>Line Width</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Width</em>' attribute.
	 * @see #setLineWidth(int)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getRasterizer_LineWidth()
	 * @model default="1" unique="false"
	 * @generated
	 */
	int getLineWidth();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer#getLineWidth <em>Line Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Width</em>' attribute.
	 * @see #getLineWidth()
	 * @generated
	 */
	void setLineWidth(int value);

	/**
	 * Returns the value of the '<em><b>Depth Clamp Enable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth Clamp Enable</em>' attribute.
	 * @see #setDepthClampEnable(boolean)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getRasterizer_DepthClampEnable()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isDepthClampEnable();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer#isDepthClampEnable <em>Depth Clamp Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth Clamp Enable</em>' attribute.
	 * @see #isDepthClampEnable()
	 * @generated
	 */
	void setDepthClampEnable(boolean value);

	/**
	 * Returns the value of the '<em><b>Discard Enable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Discard Enable</em>' attribute.
	 * @see #setDiscardEnable(boolean)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getRasterizer_DiscardEnable()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isDiscardEnable();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer#isDiscardEnable <em>Discard Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Discard Enable</em>' attribute.
	 * @see #isDiscardEnable()
	 * @generated
	 */
	void setDiscardEnable(boolean value);

	/**
	 * Returns the value of the '<em><b>Depth Bias Enable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth Bias Enable</em>' attribute.
	 * @see #setDepthBiasEnable(boolean)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getRasterizer_DepthBiasEnable()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isDepthBiasEnable();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer#isDepthBiasEnable <em>Depth Bias Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth Bias Enable</em>' attribute.
	 * @see #isDepthBiasEnable()
	 * @generated
	 */
	void setDepthBiasEnable(boolean value);

} // Rasterizer
