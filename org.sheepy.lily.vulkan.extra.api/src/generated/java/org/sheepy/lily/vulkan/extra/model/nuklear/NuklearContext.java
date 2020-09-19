/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear;

import org.sheepy.lily.vulkan.model.IVulkanResource;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticImage;

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
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getImageArrayDescriptor <em>Image Array Descriptor</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getVertexBuffer <em>Vertex Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getIndexBuffer <em>Index Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getVertexBufferMemory <em>Vertex Buffer Memory</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getCompositeDrawTask <em>Composite Draw Task</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearContext()
 * @model
 * @generated
 */
public interface NuklearContext extends IVulkanResource
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
	 * @see #setNullTexture(StaticImage)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearContext_NullTexture()
	 * @model
	 * @generated
	 */
	StaticImage getNullTexture();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getNullTexture <em>Null Texture</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Null Texture</em>' reference.
	 * @see #getNullTexture()
	 * @generated
	 */
	void setNullTexture(StaticImage value);

	/**
	 * Returns the value of the '<em><b>Image Array Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Array Descriptor</em>' reference.
	 * @see #setImageArrayDescriptor(ImageDescriptor)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearContext_ImageArrayDescriptor()
	 * @model
	 * @generated
	 */
	ImageDescriptor getImageArrayDescriptor();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getImageArrayDescriptor <em>Image Array Descriptor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Array Descriptor</em>' reference.
	 * @see #getImageArrayDescriptor()
	 * @generated
	 */
	void setImageArrayDescriptor(ImageDescriptor value);

	/**
	 * Returns the value of the '<em><b>Vertex Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertex Buffer</em>' reference.
	 * @see #setVertexBuffer(IBuffer)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearContext_VertexBuffer()
	 * @model required="true"
	 * @generated
	 */
	IBuffer getVertexBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getVertexBuffer <em>Vertex Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertex Buffer</em>' reference.
	 * @see #getVertexBuffer()
	 * @generated
	 */
	void setVertexBuffer(IBuffer value);

	/**
	 * Returns the value of the '<em><b>Index Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Buffer</em>' reference.
	 * @see #setIndexBuffer(IBuffer)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearContext_IndexBuffer()
	 * @model required="true"
	 * @generated
	 */
	IBuffer getIndexBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getIndexBuffer <em>Index Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Buffer</em>' reference.
	 * @see #getIndexBuffer()
	 * @generated
	 */
	void setIndexBuffer(IBuffer value);

	/**
	 * Returns the value of the '<em><b>Vertex Buffer Memory</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertex Buffer Memory</em>' reference.
	 * @see #setVertexBufferMemory(BufferMemory)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearContext_VertexBufferMemory()
	 * @model required="true"
	 * @generated
	 */
	BufferMemory getVertexBufferMemory();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getVertexBufferMemory <em>Vertex Buffer Memory</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertex Buffer Memory</em>' reference.
	 * @see #getVertexBufferMemory()
	 * @generated
	 */
	void setVertexBufferMemory(BufferMemory value);

	/**
	 * Returns the value of the '<em><b>Composite Draw Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite Draw Task</em>' reference.
	 * @see #setCompositeDrawTask(CompositeTask)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearContext_CompositeDrawTask()
	 * @model required="true"
	 * @generated
	 */
	CompositeTask getCompositeDrawTask();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getCompositeDrawTask <em>Composite Draw Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite Draw Task</em>' reference.
	 * @see #getCompositeDrawTask()
	 * @generated
	 */
	void setCompositeDrawTask(CompositeTask value);

} // NuklearContext
