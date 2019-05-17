/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.sheepy.lily.vulkan.model.process.IPipelineTask;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Scissor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SetScissor#getOffsetX <em>Offset X</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SetScissor#getOffsetY <em>Offset Y</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SetScissor#getWidth <em>Width</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SetScissor#getHeight <em>Height</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSetScissor()
 * @model
 * @generated
 */
public interface SetScissor extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>Offset X</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset X</em>' attribute.
	 * @see #setOffsetX(int)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSetScissor_OffsetX()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getOffsetX();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.SetScissor#getOffsetX <em>Offset X</em>}' attribute.
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
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSetScissor_OffsetY()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getOffsetY();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.SetScissor#getOffsetY <em>Offset Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset Y</em>' attribute.
	 * @see #getOffsetY()
	 * @generated
	 */
	void setOffsetY(int value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(int)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSetScissor_Width()
	 * @model unique="false"
	 * @generated
	 */
	int getWidth();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.SetScissor#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(int value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(int)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSetScissor_Height()
	 * @model unique="false"
	 * @generated
	 */
	int getHeight();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.SetScissor#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(int value);

} // SetScissor
