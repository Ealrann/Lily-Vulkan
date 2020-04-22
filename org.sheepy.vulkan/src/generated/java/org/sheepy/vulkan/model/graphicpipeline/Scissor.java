/**
 */
package org.sheepy.vulkan.model.graphicpipeline;

import org.joml.Vector2ic;
import org.sheepy.lily.core.api.model.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scissor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.Scissor#getOffsetX <em>Offset X</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.Scissor#getOffsetY <em>Offset Y</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.Scissor#getExtent <em>Extent</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getScissor()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface Scissor extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Offset X</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset X</em>' attribute.
	 * @see #setOffsetX(int)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getScissor_OffsetX()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getOffsetX();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.Scissor#getOffsetX <em>Offset X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset X</em>' attribute.
	 * @see #getOffsetX()
	 * @generated
	 */
	void setOffsetX(int value);

	/**
	 * Returns the value of the '<em><b>Offset Y</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset Y</em>' attribute.
	 * @see #setOffsetY(int)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getScissor_OffsetY()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getOffsetY();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.Scissor#getOffsetY <em>Offset Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset Y</em>' attribute.
	 * @see #getOffsetY()
	 * @generated
	 */
	void setOffsetY(int value);

	/**
	 * Returns the value of the '<em><b>Extent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extent</em>' attribute.
	 * @see #setExtent(Vector2ic)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getScissor_Extent()
	 * @model dataType="org.sheepy.lily.core.model.types.Vector2i"
	 * @generated
	 */
	Vector2ic getExtent();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.Scissor#getExtent <em>Extent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extent</em>' attribute.
	 * @see #getExtent()
	 * @generated
	 */
	void setExtent(Vector2ic value);

} // Scissor
