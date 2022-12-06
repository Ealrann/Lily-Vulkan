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
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticImage;

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
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl#getVertexBuffer <em>Vertex Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl#getIndexBuffer <em>Index Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl#getVertexBufferMemory <em>Vertex Buffer Memory</em>}</li>
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
	protected ImageDescriptor imageArrayDescriptor;

	/**
	 * The cached value of the '{@link #getVertexBuffer() <em>Vertex Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVertexBuffer()
	 * @generated
	 * @ordered
	 */
	protected IBuffer vertexBuffer;

	/**
	 * The cached value of the '{@link #getIndexBuffer() <em>Index Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexBuffer()
	 * @generated
	 * @ordered
	 */
	protected IBuffer indexBuffer;

	/**
	 * The cached value of the '{@link #getVertexBufferMemory() <em>Vertex Buffer Memory</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVertexBufferMemory()
	 * @generated
	 * @ordered
	 */
	protected BufferMemory vertexBufferMemory;

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
	public void setNullTexture(StaticImage newNullTexture)
	{
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
	public ImageDescriptor getImageArrayDescriptor()
	{
		if (imageArrayDescriptor != null && ((EObject)imageArrayDescriptor).eIsProxy())
		{
			InternalEObject oldImageArrayDescriptor = imageArrayDescriptor;
			imageArrayDescriptor = (ImageDescriptor)eResolveProxy(oldImageArrayDescriptor);
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
	public ImageDescriptor basicGetImageArrayDescriptor()
	{
		return imageArrayDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImageArrayDescriptor(ImageDescriptor newImageArrayDescriptor)
	{
		ImageDescriptor oldImageArrayDescriptor = imageArrayDescriptor;
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
	public IBuffer getVertexBuffer()
	{
		if (vertexBuffer != null && ((EObject)vertexBuffer).eIsProxy())
		{
			InternalEObject oldVertexBuffer = vertexBuffer;
			vertexBuffer = (IBuffer)eResolveProxy(oldVertexBuffer);
			if (vertexBuffer != oldVertexBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_CONTEXT__VERTEX_BUFFER, oldVertexBuffer, vertexBuffer));
			}
		}
		return vertexBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IBuffer basicGetVertexBuffer()
	{
		return vertexBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVertexBuffer(IBuffer newVertexBuffer)
	{
		IBuffer oldVertexBuffer = vertexBuffer;
		vertexBuffer = newVertexBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_CONTEXT__VERTEX_BUFFER, oldVertexBuffer, vertexBuffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IBuffer getIndexBuffer()
	{
		if (indexBuffer != null && ((EObject)indexBuffer).eIsProxy())
		{
			InternalEObject oldIndexBuffer = indexBuffer;
			indexBuffer = (IBuffer)eResolveProxy(oldIndexBuffer);
			if (indexBuffer != oldIndexBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_CONTEXT__INDEX_BUFFER, oldIndexBuffer, indexBuffer));
			}
		}
		return indexBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IBuffer basicGetIndexBuffer()
	{
		return indexBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIndexBuffer(IBuffer newIndexBuffer)
	{
		IBuffer oldIndexBuffer = indexBuffer;
		indexBuffer = newIndexBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_CONTEXT__INDEX_BUFFER, oldIndexBuffer, indexBuffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BufferMemory getVertexBufferMemory()
	{
		if (vertexBufferMemory != null && ((EObject)vertexBufferMemory).eIsProxy())
		{
			InternalEObject oldVertexBufferMemory = vertexBufferMemory;
			vertexBufferMemory = (BufferMemory)eResolveProxy(oldVertexBufferMemory);
			if (vertexBufferMemory != oldVertexBufferMemory)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_CONTEXT__VERTEX_BUFFER_MEMORY, oldVertexBufferMemory, vertexBufferMemory));
			}
		}
		return vertexBufferMemory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BufferMemory basicGetVertexBufferMemory()
	{
		return vertexBufferMemory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVertexBufferMemory(BufferMemory newVertexBufferMemory)
	{
		BufferMemory oldVertexBufferMemory = vertexBufferMemory;
		vertexBufferMemory = newVertexBufferMemory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_CONTEXT__VERTEX_BUFFER_MEMORY, oldVertexBufferMemory, vertexBufferMemory));
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
			case NuklearPackage.NUKLEAR_CONTEXT__VERTEX_BUFFER:
				if (resolve) return getVertexBuffer();
				return basicGetVertexBuffer();
			case NuklearPackage.NUKLEAR_CONTEXT__INDEX_BUFFER:
				if (resolve) return getIndexBuffer();
				return basicGetIndexBuffer();
			case NuklearPackage.NUKLEAR_CONTEXT__VERTEX_BUFFER_MEMORY:
				if (resolve) return getVertexBufferMemory();
				return basicGetVertexBufferMemory();
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
				setImageArrayDescriptor((ImageDescriptor)newValue);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__VERTEX_BUFFER:
				setVertexBuffer((IBuffer)newValue);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__INDEX_BUFFER:
				setIndexBuffer((IBuffer)newValue);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__VERTEX_BUFFER_MEMORY:
				setVertexBufferMemory((BufferMemory)newValue);
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
				setImageArrayDescriptor((ImageDescriptor)null);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__VERTEX_BUFFER:
				setVertexBuffer((IBuffer)null);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__INDEX_BUFFER:
				setIndexBuffer((IBuffer)null);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__VERTEX_BUFFER_MEMORY:
				setVertexBufferMemory((BufferMemory)null);
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
			case NuklearPackage.NUKLEAR_CONTEXT__VERTEX_BUFFER:
				return vertexBuffer != null;
			case NuklearPackage.NUKLEAR_CONTEXT__INDEX_BUFFER:
				return indexBuffer != null;
			case NuklearPackage.NUKLEAR_CONTEXT__VERTEX_BUFFER_MEMORY:
				return vertexBufferMemory != null;
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
