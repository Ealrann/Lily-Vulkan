/**
 */
package org.sheepy.lily.vulkan.model.process.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.lily.vulkan.model.process.CopyBufferTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.resource.IBuffer;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Copy Buffer Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.CopyBufferTaskImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.CopyBufferTaskImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.CopyBufferTaskImpl#getStage <em>Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.CopyBufferTaskImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.CopyBufferTaskImpl#getSrcBuffer <em>Src Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.CopyBufferTaskImpl#getDstBuffer <em>Dst Buffer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CopyBufferTaskImpl extends LilyEObject implements CopyBufferTask
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
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getStage() <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStage()
	 * @generated
	 * @ordered
	 */
	protected static final ECommandStage STAGE_EDEFAULT = ECommandStage.TRANSFER;

	/**
	 * The cached value of the '{@link #getStage() <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStage()
	 * @generated
	 * @ordered
	 */
	protected ECommandStage stage = STAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final long SIZE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected long size = SIZE_EDEFAULT;

	/**
	 * This is true if the Size attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean sizeESet;

	/**
	 * The cached value of the '{@link #getSrcBuffer() <em>Src Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcBuffer()
	 * @generated
	 * @ordered
	 */
	protected IBuffer srcBuffer;

	/**
	 * The cached value of the '{@link #getDstBuffer() <em>Dst Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstBuffer()
	 * @generated
	 * @ordered
	 */
	protected IBuffer dstBuffer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CopyBufferTaskImpl()
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
		return ProcessPackage.Literals.COPY_BUFFER_TASK;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.COPY_BUFFER_TASK__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabled()
	{
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnabled(boolean newEnabled)
	{
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.COPY_BUFFER_TASK__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IBuffer getSrcBuffer()
	{
		if (srcBuffer != null && ((EObject)srcBuffer).eIsProxy())
		{
			InternalEObject oldSrcBuffer = (InternalEObject)srcBuffer;
			srcBuffer = (IBuffer)eResolveProxy(oldSrcBuffer);
			if (srcBuffer != oldSrcBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessPackage.COPY_BUFFER_TASK__SRC_BUFFER, oldSrcBuffer, srcBuffer));
			}
		}
		return srcBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IBuffer basicGetSrcBuffer()
	{
		return srcBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSrcBuffer(IBuffer newSrcBuffer)
	{
		IBuffer oldSrcBuffer = srcBuffer;
		srcBuffer = newSrcBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.COPY_BUFFER_TASK__SRC_BUFFER, oldSrcBuffer, srcBuffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IBuffer getDstBuffer()
	{
		if (dstBuffer != null && ((EObject)dstBuffer).eIsProxy())
		{
			InternalEObject oldDstBuffer = (InternalEObject)dstBuffer;
			dstBuffer = (IBuffer)eResolveProxy(oldDstBuffer);
			if (dstBuffer != oldDstBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessPackage.COPY_BUFFER_TASK__DST_BUFFER, oldDstBuffer, dstBuffer));
			}
		}
		return dstBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IBuffer basicGetDstBuffer()
	{
		return dstBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDstBuffer(IBuffer newDstBuffer)
	{
		IBuffer oldDstBuffer = dstBuffer;
		dstBuffer = newDstBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.COPY_BUFFER_TASK__DST_BUFFER, oldDstBuffer, dstBuffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ECommandStage getStage()
	{
		return stage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStage(ECommandStage newStage)
	{
		ECommandStage oldStage = stage;
		stage = newStage == null ? STAGE_EDEFAULT : newStage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.COPY_BUFFER_TASK__STAGE, oldStage, stage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getSize()
	{
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSize(long newSize)
	{
		long oldSize = size;
		size = newSize;
		boolean oldSizeESet = sizeESet;
		sizeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.COPY_BUFFER_TASK__SIZE, oldSize, size, !oldSizeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSize()
	{
		long oldSize = size;
		boolean oldSizeESet = sizeESet;
		size = SIZE_EDEFAULT;
		sizeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ProcessPackage.COPY_BUFFER_TASK__SIZE, oldSize, SIZE_EDEFAULT, oldSizeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSize()
	{
		return sizeESet;
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
			case ProcessPackage.COPY_BUFFER_TASK__NAME:
				return getName();
			case ProcessPackage.COPY_BUFFER_TASK__ENABLED:
				return isEnabled();
			case ProcessPackage.COPY_BUFFER_TASK__STAGE:
				return getStage();
			case ProcessPackage.COPY_BUFFER_TASK__SIZE:
				return getSize();
			case ProcessPackage.COPY_BUFFER_TASK__SRC_BUFFER:
				if (resolve) return getSrcBuffer();
				return basicGetSrcBuffer();
			case ProcessPackage.COPY_BUFFER_TASK__DST_BUFFER:
				if (resolve) return getDstBuffer();
				return basicGetDstBuffer();
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
			case ProcessPackage.COPY_BUFFER_TASK__NAME:
				setName((String)newValue);
				return;
			case ProcessPackage.COPY_BUFFER_TASK__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case ProcessPackage.COPY_BUFFER_TASK__STAGE:
				setStage((ECommandStage)newValue);
				return;
			case ProcessPackage.COPY_BUFFER_TASK__SIZE:
				setSize((Long)newValue);
				return;
			case ProcessPackage.COPY_BUFFER_TASK__SRC_BUFFER:
				setSrcBuffer((IBuffer)newValue);
				return;
			case ProcessPackage.COPY_BUFFER_TASK__DST_BUFFER:
				setDstBuffer((IBuffer)newValue);
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
			case ProcessPackage.COPY_BUFFER_TASK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ProcessPackage.COPY_BUFFER_TASK__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case ProcessPackage.COPY_BUFFER_TASK__STAGE:
				setStage(STAGE_EDEFAULT);
				return;
			case ProcessPackage.COPY_BUFFER_TASK__SIZE:
				unsetSize();
				return;
			case ProcessPackage.COPY_BUFFER_TASK__SRC_BUFFER:
				setSrcBuffer((IBuffer)null);
				return;
			case ProcessPackage.COPY_BUFFER_TASK__DST_BUFFER:
				setDstBuffer((IBuffer)null);
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
			case ProcessPackage.COPY_BUFFER_TASK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ProcessPackage.COPY_BUFFER_TASK__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case ProcessPackage.COPY_BUFFER_TASK__STAGE:
				return stage != STAGE_EDEFAULT;
			case ProcessPackage.COPY_BUFFER_TASK__SIZE:
				return isSetSize();
			case ProcessPackage.COPY_BUFFER_TASK__SRC_BUFFER:
				return srcBuffer != null;
			case ProcessPackage.COPY_BUFFER_TASK__DST_BUFFER:
				return dstBuffer != null;
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
		result.append(", enabled: ");
		result.append(enabled);
		result.append(", stage: ");
		result.append(stage);
		result.append(", size: ");
		if (sizeESet) result.append(size); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //CopyBufferTaskImpl
