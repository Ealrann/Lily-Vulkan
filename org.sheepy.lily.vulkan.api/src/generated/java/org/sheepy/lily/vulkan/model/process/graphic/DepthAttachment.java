/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Depth Attachment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment#isClear <em>Clear</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getDepthAttachment()
 * @model
 * @generated
 */
public interface DepthAttachment extends ExtraAttachment
{
	/**
	 * Returns the value of the '<em><b>Clear</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clear</em>' attribute.
	 * @see #setClear(boolean)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getDepthAttachment_Clear()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isClear();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment#isClear <em>Clear</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clear</em>' attribute.
	 * @see #isClear()
	 * @generated
	 */
	void setClear(boolean value);

} // DepthAttachment
