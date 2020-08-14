/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear;

import org.sheepy.lily.vulkan.model.IVulkanResource;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.resource.ImageArrayDescriptor;
import org.sheepy.lily.vulkan.model.resource.MemoryChunk;
import org.sheepy.lily.vulkan.model.resource.StaticImage;

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
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getVertexDataProvider <em>Vertex Data Provider</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getIndexDataProvider <em>Index Data Provider</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getVertexMemoryChunk <em>Vertex Memory Chunk</em>}</li>
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

	/**
	 * Returns the value of the '<em><b>Vertex Data Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertex Data Provider</em>' reference.
	 * @see #setVertexDataProvider(NuklearVertexProvider)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearContext_VertexDataProvider()
	 * @model required="true"
	 * @generated
	 */
	NuklearVertexProvider getVertexDataProvider();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getVertexDataProvider <em>Vertex Data Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertex Data Provider</em>' reference.
	 * @see #getVertexDataProvider()
	 * @generated
	 */
	void setVertexDataProvider(NuklearVertexProvider value);

	/**
	 * Returns the value of the '<em><b>Index Data Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Data Provider</em>' reference.
	 * @see #setIndexDataProvider(NuklearIndexProvider)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearContext_IndexDataProvider()
	 * @model required="true"
	 * @generated
	 */
	NuklearIndexProvider getIndexDataProvider();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getIndexDataProvider <em>Index Data Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Data Provider</em>' reference.
	 * @see #getIndexDataProvider()
	 * @generated
	 */
	void setIndexDataProvider(NuklearIndexProvider value);

	/**
	 * Returns the value of the '<em><b>Vertex Memory Chunk</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertex Memory Chunk</em>' reference.
	 * @see #setVertexMemoryChunk(MemoryChunk)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearContext_VertexMemoryChunk()
	 * @model required="true"
	 * @generated
	 */
	MemoryChunk getVertexMemoryChunk();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getVertexMemoryChunk <em>Vertex Memory Chunk</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertex Memory Chunk</em>' reference.
	 * @see #getVertexMemoryChunk()
	 * @generated
	 */
	void setVertexMemoryChunk(MemoryChunk value);

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
