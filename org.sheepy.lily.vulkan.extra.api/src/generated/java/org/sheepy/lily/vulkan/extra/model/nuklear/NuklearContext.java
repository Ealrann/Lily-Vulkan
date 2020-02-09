/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear;

import org.sheepy.lily.core.model.resource.IResource;
import org.sheepy.lily.vulkan.model.resource.ImageArrayDescriptor;
import org.sheepy.lily.vulkan.model.resource.SampledImage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nuklear Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getFont <em>Font</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getNullTexture <em>Null Texture</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getLayoutTask <em>Layout Task</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getImageArrayDescriptor <em>Image Array Descriptor</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearContext()
 * @model
 * @generated
 */
public interface NuklearContext extends IResource
{
	/**
	 * Returns the value of the '<em><b>Font</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font</em>' reference.
	 * @see #setFont(NuklearFont)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearContext_Font()
	 * @model required="true"
	 * @generated
	 */
	NuklearFont getFont();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getFont <em>Font</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font</em>' reference.
	 * @see #getFont()
	 * @generated
	 */
	void setFont(NuklearFont value);

	/**
	 * Returns the value of the '<em><b>Null Texture</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Null Texture</em>' reference.
	 * @see #setNullTexture(SampledImage)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearContext_NullTexture()
	 * @model
	 * @generated
	 */
	SampledImage getNullTexture();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getNullTexture <em>Null Texture</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Null Texture</em>' reference.
	 * @see #getNullTexture()
	 * @generated
	 */
	void setNullTexture(SampledImage value);

	/**
	 * Returns the value of the '<em><b>Layout Task</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearLayoutTask#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout Task</em>' reference.
	 * @see #setLayoutTask(NuklearLayoutTask)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearContext_LayoutTask()
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearLayoutTask#getContext
	 * @model opposite="context" required="true"
	 * @generated
	 */
	NuklearLayoutTask getLayoutTask();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getLayoutTask <em>Layout Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout Task</em>' reference.
	 * @see #getLayoutTask()
	 * @generated
	 */
	void setLayoutTask(NuklearLayoutTask value);

	/**
	 * Returns the value of the '<em><b>Image Array Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Array Descriptor</em>' reference.
	 * @see #setImageArrayDescriptor(ImageArrayDescriptor)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearContext_ImageArrayDescriptor()
	 * @model
	 * @generated
	 */
	ImageArrayDescriptor getImageArrayDescriptor();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getImageArrayDescriptor <em>Image Array Descriptor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Array Descriptor</em>' reference.
	 * @see #getImageArrayDescriptor()
	 * @generated
	 */
	void setImageArrayDescriptor(ImageArrayDescriptor value);

} // NuklearContext
