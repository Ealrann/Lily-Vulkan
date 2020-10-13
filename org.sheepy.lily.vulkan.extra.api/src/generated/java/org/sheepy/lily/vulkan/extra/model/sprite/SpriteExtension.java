/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite;

import org.sheepy.lily.vulkan.model.process.IPipelineExtension;
import org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getDrawTask <em>Draw Task</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getIndexBufferViewer <em>Index Buffer Viewer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getVertexBufferViewer <em>Vertex Buffer Viewer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getSpritesDescriptor <em>Sprites Descriptor</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getSpriteDataSource <em>Sprite Data Source</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getSpritePipelineSpecialization <em>Sprite Pipeline Specialization</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getSpriteImageMemory <em>Sprite Image Memory</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage#getSpriteExtension()
 * @model
 * @generated
 */
public interface SpriteExtension extends IPipelineExtension, IBufferDataSource
{

	/**
	 * Returns the value of the '<em><b>Draw Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Draw Task</em>' reference.
	 * @see #setDrawTask(DrawIndexed)
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage#getSpriteExtension_DrawTask()
	 * @model required="true"
	 * @generated
	 */
	DrawIndexed getDrawTask();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getDrawTask <em>Draw Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Draw Task</em>' reference.
	 * @see #getDrawTask()
	 * @generated
	 */
	void setDrawTask(DrawIndexed value);

	/**
	 * Returns the value of the '<em><b>Index Buffer Viewer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Buffer Viewer</em>' reference.
	 * @see #setIndexBufferViewer(BufferViewer)
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage#getSpriteExtension_IndexBufferViewer()
	 * @model required="true"
	 * @generated
	 */
	BufferViewer getIndexBufferViewer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getIndexBufferViewer <em>Index Buffer Viewer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Buffer Viewer</em>' reference.
	 * @see #getIndexBufferViewer()
	 * @generated
	 */
	void setIndexBufferViewer(BufferViewer value);

	/**
	 * Returns the value of the '<em><b>Vertex Buffer Viewer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertex Buffer Viewer</em>' reference.
	 * @see #setVertexBufferViewer(BufferViewer)
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage#getSpriteExtension_VertexBufferViewer()
	 * @model required="true"
	 * @generated
	 */
	BufferViewer getVertexBufferViewer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getVertexBufferViewer <em>Vertex Buffer Viewer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertex Buffer Viewer</em>' reference.
	 * @see #getVertexBufferViewer()
	 * @generated
	 */
	void setVertexBufferViewer(BufferViewer value);

	/**
	 * Returns the value of the '<em><b>Sprites Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sprites Descriptor</em>' reference.
	 * @see #setSpritesDescriptor(ImageDescriptor)
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage#getSpriteExtension_SpritesDescriptor()
	 * @model required="true"
	 * @generated
	 */
	ImageDescriptor getSpritesDescriptor();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getSpritesDescriptor <em>Sprites Descriptor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sprites Descriptor</em>' reference.
	 * @see #getSpritesDescriptor()
	 * @generated
	 */
	void setSpritesDescriptor(ImageDescriptor value);

	/**
	 * Returns the value of the '<em><b>Sprite Data Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sprite Data Source</em>' reference.
	 * @see #setSpriteDataSource(ISpriteDataSource)
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage#getSpriteExtension_SpriteDataSource()
	 * @model
	 * @generated
	 */
	ISpriteDataSource getSpriteDataSource();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getSpriteDataSource <em>Sprite Data Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sprite Data Source</em>' reference.
	 * @see #getSpriteDataSource()
	 * @generated
	 */
	void setSpriteDataSource(ISpriteDataSource value);

	/**
	 * Returns the value of the '<em><b>Sprite Pipeline Specialization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sprite Pipeline Specialization</em>' reference.
	 * @see #setSpritePipelineSpecialization(ConstantBuffer)
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage#getSpriteExtension_SpritePipelineSpecialization()
	 * @model
	 * @generated
	 */
	ConstantBuffer getSpritePipelineSpecialization();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getSpritePipelineSpecialization <em>Sprite Pipeline Specialization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sprite Pipeline Specialization</em>' reference.
	 * @see #getSpritePipelineSpecialization()
	 * @generated
	 */
	void setSpritePipelineSpecialization(ConstantBuffer value);

	/**
	 * Returns the value of the '<em><b>Sprite Image Memory</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sprite Image Memory</em>' reference.
	 * @see #setSpriteImageMemory(MemoryChunk)
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage#getSpriteExtension_SpriteImageMemory()
	 * @model required="true"
	 * @generated
	 */
	MemoryChunk getSpriteImageMemory();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getSpriteImageMemory <em>Sprite Image Memory</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sprite Image Memory</em>' reference.
	 * @see #getSpriteImageMemory()
	 * @generated
	 */
	void setSpriteImageMemory(MemoryChunk value);
} // SpriteExtension
