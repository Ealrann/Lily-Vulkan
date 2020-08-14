/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearIndexProvider;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearVertexProvider;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.resource.ImageArrayDescriptor;
import org.sheepy.lily.vulkan.model.resource.MemoryChunk;
import org.sheepy.lily.vulkan.model.resource.StaticImage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nuklear Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl#getFont <em>Font</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl#getNullTexture <em>Null Texture</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl#getImageArrayDescriptor <em>Image Array Descriptor</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl#getVertexDataProvider <em>Vertex Data Provider</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl#getIndexDataProvider <em>Index Data Provider</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl#getVertexMemoryChunk <em>Vertex Memory Chunk</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl#getCompositeDrawTask <em>Composite Draw Task</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NuklearContextImpl extends LilyEObject implements NuklearContext
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFont() <em>Font</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFont()
	 * @generated
	 * @ordered
	 */
	protected NuklearFont font;

	/**
	 * The cached value of the '{@link #getNullTexture() <em>Null Texture</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNullTexture()
	 * @generated
	 * @ordered
	 */
	protected StaticImage nullTexture;

	/**
	 * The cached value of the '{@link #getImageArrayDescriptor() <em>Image Array Descriptor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageArrayDescriptor()
	 * @generated
	 * @ordered
	 */
	protected ImageArrayDescriptor imageArrayDescriptor;

	/**
	 * The cached value of the '{@link #getVertexDataProvider() <em>Vertex Data Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVertexDataProvider()
	 * @generated
	 * @ordered
	 */
	protected NuklearVertexProvider vertexDataProvider;

	/**
	 * The cached value of the '{@link #getIndexDataProvider() <em>Index Data Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexDataProvider()
	 * @generated
	 * @ordered
	 */
	protected NuklearIndexProvider indexDataProvider;

	/**
	 * The cached value of the '{@link #getVertexMemoryChunk() <em>Vertex Memory Chunk</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVertexMemoryChunk()
	 * @generated
	 * @ordered
	 */
	protected MemoryChunk vertexMemoryChunk;

	/**
	 * The cached value of the '{@link #getCompositeDrawTask() <em>Composite Draw Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeDrawTask()
	 * @generated
	 * @ordered
	 */
	protected CompositeTask compositeDrawTask;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NuklearContextImpl()
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
		return NuklearPackage.Literals.NUKLEAR_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_CONTEXT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NuklearFont getFont()
	{
		if (font != null && ((EObject)font).eIsProxy())
		{
			InternalEObject oldFont = font;
			font = (NuklearFont)eResolveProxy(oldFont);
			if (font != oldFont)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_CONTEXT__FONT, oldFont, font));
			}
		}
		return font;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NuklearFont basicGetFont()
	{
		return font;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFont(NuklearFont newFont)
	{
		NuklearFont oldFont = font;
		font = newFont;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_CONTEXT__FONT, oldFont, font));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StaticImage getNullTexture()
	{
		if (nullTexture != null && ((EObject)nullTexture).eIsProxy())
		{
			InternalEObject oldNullTexture = nullTexture;
			nullTexture = (StaticImage)eResolveProxy(oldNullTexture);
			if (nullTexture != oldNullTexture)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_CONTEXT__NULL_TEXTURE, oldNullTexture, nullTexture));
			}
		}
		return nullTexture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticImage basicGetNullTexture()
	{
		return nullTexture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNullTexture(StaticImage newNullTexture) {
		StaticImage oldNullTexture = nullTexture;
		nullTexture = newNullTexture;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_CONTEXT__NULL_TEXTURE, oldNullTexture, nullTexture));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImageArrayDescriptor getImageArrayDescriptor()
	{
		if (imageArrayDescriptor != null && ((EObject)imageArrayDescriptor).eIsProxy())
		{
			InternalEObject oldImageArrayDescriptor = imageArrayDescriptor;
			imageArrayDescriptor = (ImageArrayDescriptor)eResolveProxy(oldImageArrayDescriptor);
			if (imageArrayDescriptor != oldImageArrayDescriptor)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_CONTEXT__IMAGE_ARRAY_DESCRIPTOR, oldImageArrayDescriptor, imageArrayDescriptor));
			}
		}
		return imageArrayDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageArrayDescriptor basicGetImageArrayDescriptor()
	{
		return imageArrayDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImageArrayDescriptor(ImageArrayDescriptor newImageArrayDescriptor)
	{
		ImageArrayDescriptor oldImageArrayDescriptor = imageArrayDescriptor;
		imageArrayDescriptor = newImageArrayDescriptor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_CONTEXT__IMAGE_ARRAY_DESCRIPTOR, oldImageArrayDescriptor, imageArrayDescriptor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NuklearVertexProvider getVertexDataProvider()
	{
		if (vertexDataProvider != null && ((EObject)vertexDataProvider).eIsProxy())
		{
			InternalEObject oldVertexDataProvider = vertexDataProvider;
			vertexDataProvider = (NuklearVertexProvider)eResolveProxy(oldVertexDataProvider);
			if (vertexDataProvider != oldVertexDataProvider)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_CONTEXT__VERTEX_DATA_PROVIDER, oldVertexDataProvider, vertexDataProvider));
			}
		}
		return vertexDataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NuklearVertexProvider basicGetVertexDataProvider()
	{
		return vertexDataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVertexDataProvider(NuklearVertexProvider newVertexDataProvider)
	{
		NuklearVertexProvider oldVertexDataProvider = vertexDataProvider;
		vertexDataProvider = newVertexDataProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_CONTEXT__VERTEX_DATA_PROVIDER, oldVertexDataProvider, vertexDataProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NuklearIndexProvider getIndexDataProvider()
	{
		if (indexDataProvider != null && ((EObject)indexDataProvider).eIsProxy())
		{
			InternalEObject oldIndexDataProvider = indexDataProvider;
			indexDataProvider = (NuklearIndexProvider)eResolveProxy(oldIndexDataProvider);
			if (indexDataProvider != oldIndexDataProvider)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_CONTEXT__INDEX_DATA_PROVIDER, oldIndexDataProvider, indexDataProvider));
			}
		}
		return indexDataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NuklearIndexProvider basicGetIndexDataProvider()
	{
		return indexDataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIndexDataProvider(NuklearIndexProvider newIndexDataProvider)
	{
		NuklearIndexProvider oldIndexDataProvider = indexDataProvider;
		indexDataProvider = newIndexDataProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_CONTEXT__INDEX_DATA_PROVIDER, oldIndexDataProvider, indexDataProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MemoryChunk getVertexMemoryChunk()
	{
		if (vertexMemoryChunk != null && ((EObject)vertexMemoryChunk).eIsProxy())
		{
			InternalEObject oldVertexMemoryChunk = vertexMemoryChunk;
			vertexMemoryChunk = (MemoryChunk)eResolveProxy(oldVertexMemoryChunk);
			if (vertexMemoryChunk != oldVertexMemoryChunk)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_CONTEXT__VERTEX_MEMORY_CHUNK, oldVertexMemoryChunk, vertexMemoryChunk));
			}
		}
		return vertexMemoryChunk;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryChunk basicGetVertexMemoryChunk()
	{
		return vertexMemoryChunk;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVertexMemoryChunk(MemoryChunk newVertexMemoryChunk)
	{
		MemoryChunk oldVertexMemoryChunk = vertexMemoryChunk;
		vertexMemoryChunk = newVertexMemoryChunk;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_CONTEXT__VERTEX_MEMORY_CHUNK, oldVertexMemoryChunk, vertexMemoryChunk));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositeTask getCompositeDrawTask()
	{
		if (compositeDrawTask != null && ((EObject)compositeDrawTask).eIsProxy())
		{
			InternalEObject oldCompositeDrawTask = compositeDrawTask;
			compositeDrawTask = (CompositeTask)eResolveProxy(oldCompositeDrawTask);
			if (compositeDrawTask != oldCompositeDrawTask)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_CONTEXT__COMPOSITE_DRAW_TASK, oldCompositeDrawTask, compositeDrawTask));
			}
		}
		return compositeDrawTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeTask basicGetCompositeDrawTask()
	{
		return compositeDrawTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompositeDrawTask(CompositeTask newCompositeDrawTask)
	{
		CompositeTask oldCompositeDrawTask = compositeDrawTask;
		compositeDrawTask = newCompositeDrawTask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_CONTEXT__COMPOSITE_DRAW_TASK, oldCompositeDrawTask, compositeDrawTask));
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
			case NuklearPackage.NUKLEAR_CONTEXT__NAME:
				return getName();
			case NuklearPackage.NUKLEAR_CONTEXT__FONT:
				if (resolve) return getFont();
				return basicGetFont();
			case NuklearPackage.NUKLEAR_CONTEXT__NULL_TEXTURE:
				if (resolve) return getNullTexture();
				return basicGetNullTexture();
			case NuklearPackage.NUKLEAR_CONTEXT__IMAGE_ARRAY_DESCRIPTOR:
				if (resolve) return getImageArrayDescriptor();
				return basicGetImageArrayDescriptor();
			case NuklearPackage.NUKLEAR_CONTEXT__VERTEX_DATA_PROVIDER:
				if (resolve) return getVertexDataProvider();
				return basicGetVertexDataProvider();
			case NuklearPackage.NUKLEAR_CONTEXT__INDEX_DATA_PROVIDER:
				if (resolve) return getIndexDataProvider();
				return basicGetIndexDataProvider();
			case NuklearPackage.NUKLEAR_CONTEXT__VERTEX_MEMORY_CHUNK:
				if (resolve) return getVertexMemoryChunk();
				return basicGetVertexMemoryChunk();
			case NuklearPackage.NUKLEAR_CONTEXT__COMPOSITE_DRAW_TASK:
				if (resolve) return getCompositeDrawTask();
				return basicGetCompositeDrawTask();
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
			case NuklearPackage.NUKLEAR_CONTEXT__NAME:
				setName((String)newValue);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__FONT:
				setFont((NuklearFont)newValue);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__NULL_TEXTURE:
				setNullTexture((StaticImage)newValue);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__IMAGE_ARRAY_DESCRIPTOR:
				setImageArrayDescriptor((ImageArrayDescriptor)newValue);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__VERTEX_DATA_PROVIDER:
				setVertexDataProvider((NuklearVertexProvider)newValue);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__INDEX_DATA_PROVIDER:
				setIndexDataProvider((NuklearIndexProvider)newValue);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__VERTEX_MEMORY_CHUNK:
				setVertexMemoryChunk((MemoryChunk)newValue);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__COMPOSITE_DRAW_TASK:
				setCompositeDrawTask((CompositeTask)newValue);
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
			case NuklearPackage.NUKLEAR_CONTEXT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__FONT:
				setFont((NuklearFont)null);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__NULL_TEXTURE:
				setNullTexture((StaticImage)null);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__IMAGE_ARRAY_DESCRIPTOR:
				setImageArrayDescriptor((ImageArrayDescriptor)null);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__VERTEX_DATA_PROVIDER:
				setVertexDataProvider((NuklearVertexProvider)null);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__INDEX_DATA_PROVIDER:
				setIndexDataProvider((NuklearIndexProvider)null);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__VERTEX_MEMORY_CHUNK:
				setVertexMemoryChunk((MemoryChunk)null);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__COMPOSITE_DRAW_TASK:
				setCompositeDrawTask((CompositeTask)null);
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
			case NuklearPackage.NUKLEAR_CONTEXT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case NuklearPackage.NUKLEAR_CONTEXT__FONT:
				return font != null;
			case NuklearPackage.NUKLEAR_CONTEXT__NULL_TEXTURE:
				return nullTexture != null;
			case NuklearPackage.NUKLEAR_CONTEXT__IMAGE_ARRAY_DESCRIPTOR:
				return imageArrayDescriptor != null;
			case NuklearPackage.NUKLEAR_CONTEXT__VERTEX_DATA_PROVIDER:
				return vertexDataProvider != null;
			case NuklearPackage.NUKLEAR_CONTEXT__INDEX_DATA_PROVIDER:
				return indexDataProvider != null;
			case NuklearPackage.NUKLEAR_CONTEXT__VERTEX_MEMORY_CHUNK:
				return vertexMemoryChunk != null;
			case NuklearPackage.NUKLEAR_CONTEXT__COMPOSITE_DRAW_TASK:
				return compositeDrawTask != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //NuklearContextImpl
