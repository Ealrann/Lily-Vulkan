/**
 */
package org.sheepy.vulkan.model.process.graphic.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.process.AbstractProcess;
import org.sheepy.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.vulkan.model.process.graphic.ImagePipeline;

import org.sheepy.vulkan.model.process.impl.AbstractPipelineImpl;

import org.sheepy.vulkan.model.resource.Image;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Image Pipeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.impl.ImagePipelineImpl#getImage <em>Image</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.impl.ImagePipelineImpl#getImageSrcStage <em>Image Src Stage</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.impl.ImagePipelineImpl#getImageDstStage <em>Image Dst Stage</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.impl.ImagePipelineImpl#getImageSrcAccessMask <em>Image Src Access Mask</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.impl.ImagePipelineImpl#getImageDstAccessMask <em>Image Dst Access Mask</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.impl.ImagePipelineImpl#getSrcQueue <em>Src Queue</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImagePipelineImpl extends AbstractPipelineImpl implements ImagePipeline
{
	/**
	 * The cached value of the '{@link #getImage() <em>Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected Image image;

	/**
	 * The default value of the '{@link #getImageSrcStage() <em>Image Src Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageSrcStage()
	 * @generated
	 * @ordered
	 */
	protected static final EPipelineStage IMAGE_SRC_STAGE_EDEFAULT = EPipelineStage.TOP_OF_PIPE_BIT;

	/**
	 * The cached value of the '{@link #getImageSrcStage() <em>Image Src Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageSrcStage()
	 * @generated
	 * @ordered
	 */
	protected EPipelineStage imageSrcStage = IMAGE_SRC_STAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getImageDstStage() <em>Image Dst Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageDstStage()
	 * @generated
	 * @ordered
	 */
	protected static final EPipelineStage IMAGE_DST_STAGE_EDEFAULT = EPipelineStage.TOP_OF_PIPE_BIT;

	/**
	 * The cached value of the '{@link #getImageDstStage() <em>Image Dst Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageDstStage()
	 * @generated
	 * @ordered
	 */
	protected EPipelineStage imageDstStage = IMAGE_DST_STAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImageSrcAccessMask() <em>Image Src Access Mask</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageSrcAccessMask()
	 * @generated
	 * @ordered
	 */
	protected EList<EAccess> imageSrcAccessMask;

	/**
	 * The cached value of the '{@link #getImageDstAccessMask() <em>Image Dst Access Mask</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageDstAccessMask()
	 * @generated
	 * @ordered
	 */
	protected EList<EAccess> imageDstAccessMask;

	/**
	 * The cached value of the '{@link #getSrcQueue() <em>Src Queue</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcQueue()
	 * @generated
	 * @ordered
	 */
	protected AbstractProcess srcQueue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImagePipelineImpl()
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
		return GraphicPackage.Literals.IMAGE_PIPELINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Image getImage()
	{
		if (image != null && image.eIsProxy())
		{
			InternalEObject oldImage = (InternalEObject)image;
			image = (Image)eResolveProxy(oldImage);
			if (image != oldImage)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphicPackage.IMAGE_PIPELINE__IMAGE, oldImage, image));
			}
		}
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Image basicGetImage()
	{
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImage(Image newImage)
	{
		Image oldImage = image;
		image = newImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.IMAGE_PIPELINE__IMAGE, oldImage, image));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPipelineStage getImageSrcStage()
	{
		return imageSrcStage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImageSrcStage(EPipelineStage newImageSrcStage)
	{
		EPipelineStage oldImageSrcStage = imageSrcStage;
		imageSrcStage = newImageSrcStage == null ? IMAGE_SRC_STAGE_EDEFAULT : newImageSrcStage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.IMAGE_PIPELINE__IMAGE_SRC_STAGE, oldImageSrcStage, imageSrcStage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPipelineStage getImageDstStage()
	{
		return imageDstStage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImageDstStage(EPipelineStage newImageDstStage)
	{
		EPipelineStage oldImageDstStage = imageDstStage;
		imageDstStage = newImageDstStage == null ? IMAGE_DST_STAGE_EDEFAULT : newImageDstStage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.IMAGE_PIPELINE__IMAGE_DST_STAGE, oldImageDstStage, imageDstStage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EAccess> getImageSrcAccessMask()
	{
		if (imageSrcAccessMask == null)
		{
			imageSrcAccessMask = new EDataTypeEList<EAccess>(EAccess.class, this, GraphicPackage.IMAGE_PIPELINE__IMAGE_SRC_ACCESS_MASK);
		}
		return imageSrcAccessMask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EAccess> getImageDstAccessMask()
	{
		if (imageDstAccessMask == null)
		{
			imageDstAccessMask = new EDataTypeEList<EAccess>(EAccess.class, this, GraphicPackage.IMAGE_PIPELINE__IMAGE_DST_ACCESS_MASK);
		}
		return imageDstAccessMask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractProcess getSrcQueue()
	{
		if (srcQueue != null && srcQueue.eIsProxy())
		{
			InternalEObject oldSrcQueue = (InternalEObject)srcQueue;
			srcQueue = (AbstractProcess)eResolveProxy(oldSrcQueue);
			if (srcQueue != oldSrcQueue)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphicPackage.IMAGE_PIPELINE__SRC_QUEUE, oldSrcQueue, srcQueue));
			}
		}
		return srcQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractProcess basicGetSrcQueue()
	{
		return srcQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSrcQueue(AbstractProcess newSrcQueue)
	{
		AbstractProcess oldSrcQueue = srcQueue;
		srcQueue = newSrcQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.IMAGE_PIPELINE__SRC_QUEUE, oldSrcQueue, srcQueue));
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
			case GraphicPackage.IMAGE_PIPELINE__IMAGE:
				if (resolve) return getImage();
				return basicGetImage();
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_SRC_STAGE:
				return getImageSrcStage();
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_DST_STAGE:
				return getImageDstStage();
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_SRC_ACCESS_MASK:
				return getImageSrcAccessMask();
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_DST_ACCESS_MASK:
				return getImageDstAccessMask();
			case GraphicPackage.IMAGE_PIPELINE__SRC_QUEUE:
				if (resolve) return getSrcQueue();
				return basicGetSrcQueue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case GraphicPackage.IMAGE_PIPELINE__IMAGE:
				setImage((Image)newValue);
				return;
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_SRC_STAGE:
				setImageSrcStage((EPipelineStage)newValue);
				return;
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_DST_STAGE:
				setImageDstStage((EPipelineStage)newValue);
				return;
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_SRC_ACCESS_MASK:
				getImageSrcAccessMask().clear();
				getImageSrcAccessMask().addAll((Collection<? extends EAccess>)newValue);
				return;
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_DST_ACCESS_MASK:
				getImageDstAccessMask().clear();
				getImageDstAccessMask().addAll((Collection<? extends EAccess>)newValue);
				return;
			case GraphicPackage.IMAGE_PIPELINE__SRC_QUEUE:
				setSrcQueue((AbstractProcess)newValue);
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
			case GraphicPackage.IMAGE_PIPELINE__IMAGE:
				setImage((Image)null);
				return;
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_SRC_STAGE:
				setImageSrcStage(IMAGE_SRC_STAGE_EDEFAULT);
				return;
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_DST_STAGE:
				setImageDstStage(IMAGE_DST_STAGE_EDEFAULT);
				return;
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_SRC_ACCESS_MASK:
				getImageSrcAccessMask().clear();
				return;
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_DST_ACCESS_MASK:
				getImageDstAccessMask().clear();
				return;
			case GraphicPackage.IMAGE_PIPELINE__SRC_QUEUE:
				setSrcQueue((AbstractProcess)null);
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
			case GraphicPackage.IMAGE_PIPELINE__IMAGE:
				return image != null;
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_SRC_STAGE:
				return imageSrcStage != IMAGE_SRC_STAGE_EDEFAULT;
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_DST_STAGE:
				return imageDstStage != IMAGE_DST_STAGE_EDEFAULT;
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_SRC_ACCESS_MASK:
				return imageSrcAccessMask != null && !imageSrcAccessMask.isEmpty();
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_DST_ACCESS_MASK:
				return imageDstAccessMask != null && !imageDstAccessMask.isEmpty();
			case GraphicPackage.IMAGE_PIPELINE__SRC_QUEUE:
				return srcQueue != null;
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
		result.append(" (imageSrcStage: ");
		result.append(imageSrcStage);
		result.append(", imageDstStage: ");
		result.append(imageDstStage);
		result.append(", imageSrcAccessMask: ");
		result.append(imageSrcAccessMask);
		result.append(", imageDstAccessMask: ");
		result.append(imageDstAccessMask);
		result.append(')');
		return result.toString();
	}

} //ImagePipelineImpl
