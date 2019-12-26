/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear;

import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.resource.Texture2DArray;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nuklear Layout Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearLayoutTask#getContext <em>Context</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearLayoutTask#getImageArray <em>Image Array</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearLayoutTask()
 * @model
 * @generated
 */
public interface NuklearLayoutTask extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getLayoutTask <em>Layout Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #setContext(NuklearContext)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearLayoutTask_Context()
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getLayoutTask
	 * @model opposite="layoutTask" required="true"
	 * @generated
	 */
	NuklearContext getContext();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearLayoutTask#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(NuklearContext value);

	/**
	 * Returns the value of the '<em><b>Image Array</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Array</em>' reference.
	 * @see #setImageArray(Texture2DArray)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearLayoutTask_ImageArray()
	 * @model
	 * @generated
	 */
	Texture2DArray getImageArray();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearLayoutTask#getImageArray <em>Image Array</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Array</em>' reference.
	 * @see #getImageArray()
	 * @generated
	 */
	void setImageArray(Texture2DArray value);

} // NuklearLayoutTask
