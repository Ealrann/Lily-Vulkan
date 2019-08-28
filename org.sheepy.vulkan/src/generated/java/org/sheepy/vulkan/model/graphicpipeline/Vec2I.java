/**
 */
package org.sheepy.vulkan.model.graphicpipeline;

import org.sheepy.lily.core.api.adapter.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vec2 I</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.Vec2I#getX <em>X</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.Vec2I#getY <em>Y</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getVec2I()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface Vec2I extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(int)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getVec2I_X()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getX();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.Vec2I#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(int value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(int)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getVec2I_Y()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getY();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.Vec2I#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(int value);

} // Vec2I
