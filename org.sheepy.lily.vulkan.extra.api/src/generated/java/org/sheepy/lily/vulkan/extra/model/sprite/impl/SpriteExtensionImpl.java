/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.vulkan.extra.model.sprite.ISpriteDataSource;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension;
import org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage;
import org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteExtensionImpl#getDrawTask <em>Draw Task</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteExtensionImpl#getIndexBufferViewer <em>Index Buffer Viewer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteExtensionImpl#getVertexBufferViewer <em>Vertex Buffer Viewer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteExtensionImpl#getSpritesDescriptor <em>Sprites Descriptor</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteExtensionImpl#getSpriteDataSource <em>Sprite Data Source</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteExtensionImpl#getSpritePipelineSpecialization <em>Sprite Pipeline Specialization</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteExtensionImpl#getSpriteImageMemory <em>Sprite Image Memory</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpriteExtensionImpl extends LilyEObject implements SpriteExtension
{
	/**
	 * The cached value of the '{@link #getDrawTask() <em>Draw Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDrawTask()
	 * @generated
	 * @ordered
	 */
	protected DrawIndexed drawTask;
	/**
	 * The cached value of the '{@link #getIndexBufferViewer() <em>Index Buffer Viewer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexBufferViewer()
	 * @generated
	 * @ordered
	 */
	protected BufferViewer indexBufferViewer;

	/**
	 * The cached value of the '{@link #getVertexBufferViewer() <em>Vertex Buffer Viewer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVertexBufferViewer()
	 * @generated
	 * @ordered
	 */
	protected BufferViewer vertexBufferViewer;
	/**
	 * The cached value of the '{@link #getSpritesDescriptor() <em>Sprites Descriptor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpritesDescriptor()
	 * @generated
	 * @ordered
	 */
	protected ImageDescriptor spritesDescriptor;
	/**
	 * The cached value of the '{@link #getSpriteDataSource() <em>Sprite Data Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpriteDataSource()
	 * @generated
	 * @ordered
	 */
	protected ISpriteDataSource spriteDataSource;

	/**
	 * The cached value of the '{@link #getSpritePipelineSpecialization() <em>Sprite Pipeline Specialization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpritePipelineSpecialization()
	 * @generated
	 * @ordered
	 */
	protected ConstantBuffer spritePipelineSpecialization;

	/**
	 * The cached value of the '{@link #getSpriteImageMemory() <em>Sprite Image Memory</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpriteImageMemory()
	 * @generated
	 * @ordered
	 */
	protected MemoryChunk spriteImageMemory;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpriteExtensionImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return SpritePackage.Literals.SPRITE_EXTENSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DrawIndexed getDrawTask()
	{
		if (drawTask != null && ((EObject)drawTask).eIsProxy())
		{
			InternalEObject oldDrawTask = (InternalEObject)drawTask;
			drawTask = (DrawIndexed)eResolveProxy(oldDrawTask);
			if (drawTask != oldDrawTask)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpritePackage.SPRITE_EXTENSION__DRAW_TASK, oldDrawTask, drawTask));
			}
		}
		return drawTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DrawIndexed basicGetDrawTask()
	{
		return drawTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDrawTask(DrawIndexed newDrawTask)
	{
		DrawIndexed oldDrawTask = drawTask;
		drawTask = newDrawTask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpritePackage.SPRITE_EXTENSION__DRAW_TASK, oldDrawTask, drawTask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BufferViewer getIndexBufferViewer()
	{
		if (indexBufferViewer != null && ((EObject)indexBufferViewer).eIsProxy())
		{
			InternalEObject oldIndexBufferViewer = (InternalEObject)indexBufferViewer;
			indexBufferViewer = (BufferViewer)eResolveProxy(oldIndexBufferViewer);
			if (indexBufferViewer != oldIndexBufferViewer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpritePackage.SPRITE_EXTENSION__INDEX_BUFFER_VIEWER, oldIndexBufferViewer, indexBufferViewer));
			}
		}
		return indexBufferViewer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BufferViewer basicGetIndexBufferViewer()
	{
		return indexBufferViewer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIndexBufferViewer(BufferViewer newIndexBufferViewer)
	{
		BufferViewer oldIndexBufferViewer = indexBufferViewer;
		indexBufferViewer = newIndexBufferViewer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpritePackage.SPRITE_EXTENSION__INDEX_BUFFER_VIEWER, oldIndexBufferViewer, indexBufferViewer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BufferViewer getVertexBufferViewer()
	{
		if (vertexBufferViewer != null && ((EObject)vertexBufferViewer).eIsProxy())
		{
			InternalEObject oldVertexBufferViewer = (InternalEObject)vertexBufferViewer;
			vertexBufferViewer = (BufferViewer)eResolveProxy(oldVertexBufferViewer);
			if (vertexBufferViewer != oldVertexBufferViewer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpritePackage.SPRITE_EXTENSION__VERTEX_BUFFER_VIEWER, oldVertexBufferViewer, vertexBufferViewer));
			}
		}
		return vertexBufferViewer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BufferViewer basicGetVertexBufferViewer()
	{
		return vertexBufferViewer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVertexBufferViewer(BufferViewer newVertexBufferViewer)
	{
		BufferViewer oldVertexBufferViewer = vertexBufferViewer;
		vertexBufferViewer = newVertexBufferViewer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpritePackage.SPRITE_EXTENSION__VERTEX_BUFFER_VIEWER, oldVertexBufferViewer, vertexBufferViewer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImageDescriptor getSpritesDescriptor()
	{
		if (spritesDescriptor != null && ((EObject)spritesDescriptor).eIsProxy())
		{
			InternalEObject oldSpritesDescriptor = (InternalEObject)spritesDescriptor;
			spritesDescriptor = (ImageDescriptor)eResolveProxy(oldSpritesDescriptor);
			if (spritesDescriptor != oldSpritesDescriptor)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpritePackage.SPRITE_EXTENSION__SPRITES_DESCRIPTOR, oldSpritesDescriptor, spritesDescriptor));
			}
		}
		return spritesDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageDescriptor basicGetSpritesDescriptor()
	{
		return spritesDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpritesDescriptor(ImageDescriptor newSpritesDescriptor)
	{
		ImageDescriptor oldSpritesDescriptor = spritesDescriptor;
		spritesDescriptor = newSpritesDescriptor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpritePackage.SPRITE_EXTENSION__SPRITES_DESCRIPTOR, oldSpritesDescriptor, spritesDescriptor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ISpriteDataSource getSpriteDataSource()
	{
		if (spriteDataSource != null && ((EObject)spriteDataSource).eIsProxy())
		{
			InternalEObject oldSpriteDataSource = (InternalEObject)spriteDataSource;
			spriteDataSource = (ISpriteDataSource)eResolveProxy(oldSpriteDataSource);
			if (spriteDataSource != oldSpriteDataSource)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpritePackage.SPRITE_EXTENSION__SPRITE_DATA_SOURCE, oldSpriteDataSource, spriteDataSource));
			}
		}
		return spriteDataSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISpriteDataSource basicGetSpriteDataSource()
	{
		return spriteDataSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpriteDataSource(ISpriteDataSource newSpriteDataSource)
	{
		ISpriteDataSource oldSpriteDataSource = spriteDataSource;
		spriteDataSource = newSpriteDataSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpritePackage.SPRITE_EXTENSION__SPRITE_DATA_SOURCE, oldSpriteDataSource, spriteDataSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConstantBuffer getSpritePipelineSpecialization()
	{
		if (spritePipelineSpecialization != null && ((EObject)spritePipelineSpecialization).eIsProxy())
		{
			InternalEObject oldSpritePipelineSpecialization = (InternalEObject)spritePipelineSpecialization;
			spritePipelineSpecialization = (ConstantBuffer)eResolveProxy(oldSpritePipelineSpecialization);
			if (spritePipelineSpecialization != oldSpritePipelineSpecialization)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpritePackage.SPRITE_EXTENSION__SPRITE_PIPELINE_SPECIALIZATION, oldSpritePipelineSpecialization, spritePipelineSpecialization));
			}
		}
		return spritePipelineSpecialization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstantBuffer basicGetSpritePipelineSpecialization()
	{
		return spritePipelineSpecialization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpritePipelineSpecialization(ConstantBuffer newSpritePipelineSpecialization)
	{
		ConstantBuffer oldSpritePipelineSpecialization = spritePipelineSpecialization;
		spritePipelineSpecialization = newSpritePipelineSpecialization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpritePackage.SPRITE_EXTENSION__SPRITE_PIPELINE_SPECIALIZATION, oldSpritePipelineSpecialization, spritePipelineSpecialization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MemoryChunk getSpriteImageMemory()
	{
		if (spriteImageMemory != null && ((EObject)spriteImageMemory).eIsProxy())
		{
			InternalEObject oldSpriteImageMemory = (InternalEObject)spriteImageMemory;
			spriteImageMemory = (MemoryChunk)eResolveProxy(oldSpriteImageMemory);
			if (spriteImageMemory != oldSpriteImageMemory)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpritePackage.SPRITE_EXTENSION__SPRITE_IMAGE_MEMORY, oldSpriteImageMemory, spriteImageMemory));
			}
		}
		return spriteImageMemory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryChunk basicGetSpriteImageMemory()
	{
		return spriteImageMemory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpriteImageMemory(MemoryChunk newSpriteImageMemory)
	{
		MemoryChunk oldSpriteImageMemory = spriteImageMemory;
		spriteImageMemory = newSpriteImageMemory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpritePackage.SPRITE_EXTENSION__SPRITE_IMAGE_MEMORY, oldSpriteImageMemory, spriteImageMemory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case SpritePackage.SPRITE_EXTENSION__DRAW_TASK:
				if (resolve) return getDrawTask();
				return basicGetDrawTask();
			case SpritePackage.SPRITE_EXTENSION__INDEX_BUFFER_VIEWER:
				if (resolve) return getIndexBufferViewer();
				return basicGetIndexBufferViewer();
			case SpritePackage.SPRITE_EXTENSION__VERTEX_BUFFER_VIEWER:
				if (resolve) return getVertexBufferViewer();
				return basicGetVertexBufferViewer();
			case SpritePackage.SPRITE_EXTENSION__SPRITES_DESCRIPTOR:
				if (resolve) return getSpritesDescriptor();
				return basicGetSpritesDescriptor();
			case SpritePackage.SPRITE_EXTENSION__SPRITE_DATA_SOURCE:
				if (resolve) return getSpriteDataSource();
				return basicGetSpriteDataSource();
			case SpritePackage.SPRITE_EXTENSION__SPRITE_PIPELINE_SPECIALIZATION:
				if (resolve) return getSpritePipelineSpecialization();
				return basicGetSpritePipelineSpecialization();
			case SpritePackage.SPRITE_EXTENSION__SPRITE_IMAGE_MEMORY:
				if (resolve) return getSpriteImageMemory();
				return basicGetSpriteImageMemory();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case SpritePackage.SPRITE_EXTENSION__DRAW_TASK:
				setDrawTask((DrawIndexed)newValue);
				return;
			case SpritePackage.SPRITE_EXTENSION__INDEX_BUFFER_VIEWER:
				setIndexBufferViewer((BufferViewer)newValue);
				return;
			case SpritePackage.SPRITE_EXTENSION__VERTEX_BUFFER_VIEWER:
				setVertexBufferViewer((BufferViewer)newValue);
				return;
			case SpritePackage.SPRITE_EXTENSION__SPRITES_DESCRIPTOR:
				setSpritesDescriptor((ImageDescriptor)newValue);
				return;
			case SpritePackage.SPRITE_EXTENSION__SPRITE_DATA_SOURCE:
				setSpriteDataSource((ISpriteDataSource)newValue);
				return;
			case SpritePackage.SPRITE_EXTENSION__SPRITE_PIPELINE_SPECIALIZATION:
				setSpritePipelineSpecialization((ConstantBuffer)newValue);
				return;
			case SpritePackage.SPRITE_EXTENSION__SPRITE_IMAGE_MEMORY:
				setSpriteImageMemory((MemoryChunk)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case SpritePackage.SPRITE_EXTENSION__DRAW_TASK:
				setDrawTask((DrawIndexed)null);
				return;
			case SpritePackage.SPRITE_EXTENSION__INDEX_BUFFER_VIEWER:
				setIndexBufferViewer((BufferViewer)null);
				return;
			case SpritePackage.SPRITE_EXTENSION__VERTEX_BUFFER_VIEWER:
				setVertexBufferViewer((BufferViewer)null);
				return;
			case SpritePackage.SPRITE_EXTENSION__SPRITES_DESCRIPTOR:
				setSpritesDescriptor((ImageDescriptor)null);
				return;
			case SpritePackage.SPRITE_EXTENSION__SPRITE_DATA_SOURCE:
				setSpriteDataSource((ISpriteDataSource)null);
				return;
			case SpritePackage.SPRITE_EXTENSION__SPRITE_PIPELINE_SPECIALIZATION:
				setSpritePipelineSpecialization((ConstantBuffer)null);
				return;
			case SpritePackage.SPRITE_EXTENSION__SPRITE_IMAGE_MEMORY:
				setSpriteImageMemory((MemoryChunk)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case SpritePackage.SPRITE_EXTENSION__DRAW_TASK:
				return drawTask != null;
			case SpritePackage.SPRITE_EXTENSION__INDEX_BUFFER_VIEWER:
				return indexBufferViewer != null;
			case SpritePackage.SPRITE_EXTENSION__VERTEX_BUFFER_VIEWER:
				return vertexBufferViewer != null;
			case SpritePackage.SPRITE_EXTENSION__SPRITES_DESCRIPTOR:
				return spritesDescriptor != null;
			case SpritePackage.SPRITE_EXTENSION__SPRITE_DATA_SOURCE:
				return spriteDataSource != null;
			case SpritePackage.SPRITE_EXTENSION__SPRITE_PIPELINE_SPECIALIZATION:
				return spritePipelineSpecialization != null;
			case SpritePackage.SPRITE_EXTENSION__SPRITE_IMAGE_MEMORY:
				return spriteImageMemory != null;
		}
		return super.eIsSet(featureID);
	}

} //SpriteExtensionImpl
